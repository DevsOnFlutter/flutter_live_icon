package com.hackthedeveloper.live_icon;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MethodCallImplementation implements MethodChannel.MethodCallHandler {
    private static final String TAG = LiveIconPlugin.getTAG();

    private final Context context;
    private Activity activity;

    private static List<String> classNames = null;

    MethodCallImplementation(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    void setActivity(Activity activity) {
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {

        switch (call.method) {
            case "initialize":
            {
                classNames = call.arguments();
                break;
            }
            case "switchIconTo":
            {
                switchIconTo(call);
                break;
            }
            default:
                result.notImplemented();
                break;
        }
    }

    private void switchIconTo(MethodCall call) {
        if(classNames == null || classNames.isEmpty()) {
            Log.e(TAG,"Initialization Failed!");
            Log.i(TAG,"List all the activity-alias class names in initialize()");
            return;
        }

        List<String> args = call.arguments();
        String className = args.get(0);

        PackageManager pm = activity.getPackageManager();
        String packageName = activity.getPackageName();
        int componentState = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
        int i=0;
        for(;i<classNames.size();i++) {
            ComponentName cn = new ComponentName(packageName, packageName+"."+classNames.get(i));
            if(className.equals(classNames.get(i))) {
                componentState = PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
            }
            pm.setComponentEnabledSetting(cn, componentState, PackageManager.DONT_KILL_APP);
        }

        if(i>classNames.size()) {
            Log.e(TAG,"class name "+className+" did not match in the initialized list.");
            return;
        }
        Log.d(TAG,"Icon switched to "+className);
    }
}


