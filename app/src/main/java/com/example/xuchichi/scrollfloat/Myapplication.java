package com.example.xuchichi.scrollfloat;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by xuchichi on 2017/4/6.
 */
public class Myapplication extends MultiDexApplication {
    SharedPreferences preferences;
    public static Myapplication myapplication;
   public static SharePerferencesUtil spUtil;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myapplication = this;
        spUtil = new SharePerferencesUtil(getApplicationContext());
    }

    public static synchronized Myapplication getInstance() {
        return myapplication;
    }
}
