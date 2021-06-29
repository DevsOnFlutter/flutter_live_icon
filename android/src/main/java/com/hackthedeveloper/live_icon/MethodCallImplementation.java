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
            case "switchTo":
                switchTo(call);
                break;
            default:
                result.notImplemented();
                break;
        }
    }

    private void switchTo(MethodCall call) {
        List<Map<String, String>> args = call.arguments();
        String iconName = args.get(0).get("iconName");
        String className = args.get(0).get("className");
        PackageManager pm = activity.getPackageManager();


        String packageName = activity.getPackageName();
//        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
//        String mainActivityClass = launchIntent.getComponent().getClassName();

        ComponentName darkThemeCN = new ComponentName(packageName, packageName+"."+className);
        ComponentName lightThemeCN = new ComponentName(packageName, packageName+"."+"LightTheme");
        ComponentName mainThemeCN = new ComponentName(packageName, packageName+"."+"MainActivity");


        pm.setComponentEnabledSetting(lightThemeCN,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        pm.setComponentEnabledSetting(mainThemeCN,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        pm.setComponentEnabledSetting(darkThemeCN,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);

        Log.d(TAG,"DONE");
    }
}


