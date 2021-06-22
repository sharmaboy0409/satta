package com.game.dubaisattagame.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.game.dubaisattagame.activities.MainActivity;
import com.game.dubaisattagame.activities.StartActivity;

public class SharedPreferenceLIB {
    private Context context;
    private SharedPreferences prefs;
    private static final String LOGIN_PREFERENCE="com.game.dubaisattagame";
    public SharedPreferenceLIB(Context mContext) {
        this.context = mContext;
        prefs = this.context.getSharedPreferences(LOGIN_PREFERENCE, Context.MODE_PRIVATE);
    }





    public  void YearSave(String Year) {

        prefs.edit().putString("Year", Year).apply();

    }
    public  String YearFetch() {
        return prefs.getString("Year", "");
    }
    public  void MonthSave(String Month) {

        prefs.edit().putString("Month", Month).apply();

    }
    public  String MonthFetch() {
        return prefs.getString("Month", "");
    }


}
