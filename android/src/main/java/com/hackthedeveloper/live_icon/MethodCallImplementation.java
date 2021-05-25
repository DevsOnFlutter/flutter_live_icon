package com.hackthedeveloper.live_icon;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
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

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {

        switch (call.method) {
            case "initialize":
                initialize(call);
                break;
            default:
                result.notImplemented();
                break;
        }
    }

    private void initialize(MethodCall call) {
        List<Map<String, String>> args = call.arguments();
        final int numberOfIcons = args.size();
    }
}
