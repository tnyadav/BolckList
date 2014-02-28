package com.tn.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SharedPreferencesUtil {
	public static final int MODE_PRIVATE = 0;

	
	
	/*public static void saveObject(Context context, String key, Object object) {

		SharedPreferences appSharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(context.getApplicationContext());
		Editor prefsEditor = appSharedPrefs.edit();
		Gson gson = new Gson();
		String json = gson.toJson(object);
		prefsEditor.putString(key, json);
		prefsEditor.commit();

	}*/

	public static void saveStringPreferences(Context context, String key,
			String value) {
		SharedPreferences sPrefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = sPrefs.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static void saveIntegerPreferences(Context context, String key,
			Integer value) {
		SharedPreferences sPrefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = sPrefs.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public static void saveBooleanPreferences(Context context, String key,
			Boolean value) {
		SharedPreferences sPrefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = sPrefs.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
	public static void saveLongPreferences(Context context, String key,
			Long value) {
		SharedPreferences sPrefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = sPrefs.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	
	public static void deletePreferences(Context context, String key) {
		SharedPreferences sPrefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = sPrefs.edit();
		editor.remove(key);
		editor.commit();
	}

	public static Boolean getBooleanPreferences(Context context, String key) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		Boolean savedPref = sharedPreferences.getBoolean(key, false);
		return savedPref;
	}

	public static String getStringPreferences(Context context, String key) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		String savedPref = sharedPreferences.getString(key, "");
		return savedPref;
	}

	public static Integer getIntegerPreferences(Context context, String key) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		Integer savedPref = sharedPreferences.getInt(key, 0);
		return savedPref;
	}
	public static Long getLongPreferences(Context context, String key) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		Long savedPref = sharedPreferences.getLong(key, 0);
		return savedPref;
	}
	public static void clearAllSharedPreferencesList(Context context) {
		SharedPreferences sPrefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor sEdit = sPrefs.edit();
		sEdit.clear();
		sEdit.commit();
	}


}
