package com.hackthedeveloper.live_icon;

import android.app.Activity;
import android.content.Context;
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
            case "initialize":
                initialize(call);
                break;
            default:
                result.notImplemented();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initialize(MethodCall call) {
        List<Map<String, String>> args = call.arguments();
        final int numberOfIcons = args.size();
        for(Map<String,String> arg : args ){
            Log.d(TAG, "=====================>initialize: ");
            String className = arg.get("className");
            File file = new File(className+".java");
            try {
                Log.d(TAG, "=====================>1st try: ");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file.exists()) {
                // Returning the file name
                System.out.println("File name: " + file.getName());

                // Returning the path of the file
                System.out.println("Absolute path: " + file.getAbsolutePath());

                // Displaying whether the file is writable
                System.out.println("Writeable: " + file.canWrite());

                // Displaying whether the file is readable or not
                System.out.println("Readable " + file.canRead());

                // Returning the length of the file in bytes
                System.out.println("File size in bytes " + file.length());
            } else {
                System.out.println("The file does not exist.");
            }
            try {
                Log.d(TAG, "=====================>2nd try: ");
                FileWriter writeFile = new FileWriter(className+".java");
                writeFile.write("package \"com.hackthedeveloper.live_icon\";");
                writeFile.write(System.lineSeparator());
                writeFile.write("class "+className+"{}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

    }


