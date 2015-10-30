package com.example.utility;

import android.content.Context;

/**
 * Created by 慎也 on 2015/10/28.
 */
public class PasswordUtil {

    private final static String PREF_KEY_LOGIN_PASSWORD = "PREF_KEY_LOGIN_PASSWORD";

    public boolean  putLoginPassword(Context context, String pass){
        return PreferencesUtil.savePreference(context, PREF_KEY_LOGIN_PASSWORD, (Object)pass);

    }

    public String getLoginPassword(Context context) {
        return PreferencesUtil.loadPreference(context, PREF_KEY_LOGIN_PASSWORD, "");
    }

    public boolean passCodeCheck(int num1, int num2, int num3, int num4) {



        if (num1 == num2 && num2 == num3 && num3 == num4) {
            return false;
        }
        if ((num1 + 1) == num2 && (num2 + 1) == num3 && (num3 + 1) == num4) {
            return false;
        }
        if ((num4 + 1) == num3 && (num3 + 1) == num2 && (num2 + 1) == num1) {
            return false;
        }

        return true;
    }
}


