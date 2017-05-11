package com.example.xuchichi.scrollfloat.entitys;

import android.text.TextUtils;

import com.example.xuchichi.scrollfloat.Myapplication;

/**
 * Created by xuchichi on 2017/4/21.
 */
public class UserInfoUtil {
    public static void isLogin(String isLogin){
        Myapplication.getInstance().spUtil.setShareBoolean("isLogin",true);
    }
    public static void saveLoginToken(String loginToken) {
        if (!TextUtils.isEmpty(loginToken)) {
            Myapplication.getInstance().spUtil.setSharedString("loginToken", loginToken);
        }

    }

    public static String getLoginToken() {
        String loginToken = Myapplication.getInstance().spUtil.getShareString("loginToken");
        if (!TextUtils.isEmpty(loginToken)) {
            return loginToken;

        }
        return "";
    }
}
