package com.rnnewarchitecturelibrary;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import java.util.Map;
import java.util.HashMap;
import android.os.Build;

public class CalculatorModuleImpl {

    public static final String NAME = "Calculator";

    public static void add(double a, double b, Promise promise) {
        promise.resolve(a + b);
    }

    public static void returnPhoneInfo(Promise promise) {
        WritableMap phoneInfo = Arguments.createMap();

        phoneInfo.putString("brand", Build.BRAND);
        phoneInfo.putString("model", Build.MODEL);
        phoneInfo.putString("version", Build.VERSION.RELEASE);

        promise.resolve(phoneInfo);
    }
}