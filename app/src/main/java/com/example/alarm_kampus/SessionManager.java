package com.example.alarm_kampus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import com.example.alarm_kampus.model.login.DataItem;

public class SessionManager {

    private static final String SHARED_REF_NAME = "ALARM KAMPUS";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_PASSWORD = "keypassword";
    private static final String KEY_ALAMAT = "keyalamat";
    private static final String KEY_EMAIL = "keyemail";

    private static final String KEY_STB = "keystb";

    private static SessionManager MsessionManager;
    private static Context Mcontext;

    private SessionManager(Context context) {
        Mcontext = context;
    }

    public static synchronized SessionManager getInstance(Context context) {
        if (MsessionManager == null) {
            MsessionManager = new SessionManager(context);
        }
        return MsessionManager;
    }

    public void userLogin (DataItem dataItem) {
        SharedPreferences sharedPreferences = Mcontext.getSharedPreferences(SHARED_REF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, dataItem.getNmmhs());
        editor.putString(KEY_PASSWORD, dataItem.getStb());
        editor.putString(KEY_STB, dataItem.getStb());
        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = Mcontext.getSharedPreferences(SHARED_REF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null) != null;
    }

    public DataItem getDataItem() {
        SharedPreferences sharedPreferences = Mcontext.getSharedPreferences(SHARED_REF_NAME, Context.MODE_PRIVATE);
        return new DataItem (
            sharedPreferences.getString(KEY_USERNAME, null),
            sharedPreferences.getString(KEY_PASSWORD, null),
            sharedPreferences.getString(KEY_STB, null),
            sharedPreferences.getString(KEY_ALAMAT, null),
            sharedPreferences.getString(KEY_EMAIL, null)

        );
    }

    public void logout() {
        SharedPreferences sharedPreferences = Mcontext.getSharedPreferences(SHARED_REF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Mcontext.startActivity(new Intent(Mcontext, loginActivity.class));
    }

}
