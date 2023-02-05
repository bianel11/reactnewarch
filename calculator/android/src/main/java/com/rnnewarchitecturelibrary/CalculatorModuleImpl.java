package com.rnnewarchitecturelibrary;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import java.util.Map;
import java.util.HashMap;
import android.os.Build;

public class CalculatorModuleImpl {

    public static final String NAME = "Calculator";

    public static void add(double a, double b, Promise promise) {
        promise.resolve(a + b);
    }

    public static void returnPhoneInfo(Promise promise) {
        Map<String, Object> phoneInfo = new HashMap<>();
        phoneInfo.put("brand", Build.BRAND);
        phoneInfo.put("model", Build.MODEL);
        phoneInfo.put("version", Build.VERSION.RELEASE);

        promise.resolve(mapToJson(phoneInfo));
    }
    
    // this method is used to convert Map to JSON
    // Gson is not used because it is not available without adding dependency
    // this need to change to use WriteableMap or ReadableMap
    public static String mapToJson(Map<String, Object> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            json.append("\"" + entry.getKey() + "\":");

            if (entry.getValue() instanceof String) {
            json.append("\"" + entry.getValue() + "\"");
            } else {
            json.append(entry.getValue());
            }

            json.append(",");
        }

        json.deleteCharAt(json.length() - 1);
        json.append("}");

        return json.toString();
    }

}