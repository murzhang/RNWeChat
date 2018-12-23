package com.testreactnavigation;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by yubo on 2017/9/6.
 */

public class UpgradeModule extends ReactContextBaseJavaModule {

    private int versionCode;
    private String versionName;

    public UpgradeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        try {
            PackageManager packageManager = reactContext.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(reactContext.getPackageName(), 0);
            versionCode = packageInfo.versionCode;
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "UpgradeModule";
    }

    @ReactMethod
    public void getVersionCodeName(Callback callback) {
        if (callback != null) {
            callback.invoke(versionCode, versionName);
        }
    }
}
