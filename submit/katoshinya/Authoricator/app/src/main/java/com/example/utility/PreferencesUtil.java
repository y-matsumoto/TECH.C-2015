package com.example.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 慎也 on 2015/10/28.
 */

public class PreferencesUtil {

    public static String loadPreference(Context context, String key,
                                        String defValue) {
        SharedPreferences preference = context.getSharedPreferences("pref",
                Context.MODE_PRIVATE);
        return preference.getString(key, defValue);
    }


    public static boolean savePreference(Context context, String key,
                                         Object value) {
        SharedPreferences preference = context.getSharedPreferences("pref",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();

        if (value instanceof String)
            editor.putString(key, (String) value);
        else if (value instanceof Integer)
            editor.putInt(key, (Integer) value);
        else if (value instanceof Boolean)
            editor.putBoolean(key, (Boolean) value);
        else if (value instanceof Long)
            editor.putLong(key, (Long) value);
        else if (value instanceof Float)
            editor.putFloat(key, (Float) value);

        return editor.commit();
    }
}