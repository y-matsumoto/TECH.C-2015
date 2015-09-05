package com.example.authoricator;

import android.content.Context;

import com.example.utility.PreferencesUtil;
public class PutPassword {

	private final static String PREF_KEY_LOGIN_PASSWORD = "PREF_KEY_LOGIN_PASSWORD";

	public boolean  putLoginPassword(Context context, String pass){
		return PreferencesUtil.savePreference(context ,PREF_KEY_LOGIN_PASSWORD, (Object)pass);

	}
}
