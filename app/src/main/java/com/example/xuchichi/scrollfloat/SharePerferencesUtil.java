package com.example.xuchichi.scrollfloat;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xuchichi on 2017/4/21.
 */
public class SharePerferencesUtil {
    public static SharedPreferences sp;
    public static String shared_pre_data = "shared_pre_data";

    public SharePerferencesUtil(Context context) {
        sp = context.getSharedPreferences(shared_pre_data, Context.MODE_PRIVATE);
    }

    public void setSharedString(String key, String value) {
        sp.edit().putString(key, value).commit();
    }

    public String getShareString(String key) {
        return sp.getString(key, "");
    }

    public void setShareBoolean(String key, boolean booleans) {
        sp.edit().putBoolean(key, booleans).commit();
    }
    public boolean getShareBoolean(String key, boolean delfValue){
        return sp.getBoolean(key,delfValue);
    }
}
