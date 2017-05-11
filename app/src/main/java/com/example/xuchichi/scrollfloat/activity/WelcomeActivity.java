package com.example.xuchichi.scrollfloat.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.LauncherApps;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.xuchichi.scrollfloat.R;
import com.example.xuchichi.scrollfloat.entitys.UserInfoUtil;

public class WelcomeActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomr);
        init();
    }

    Handler handler = new Handler();

    public void init() {
        sharedPreferences = getSharedPreferences("isFirst", MODE_APPEND);
        boolean isFirst = sharedPreferences.getBoolean("firstTime", true);
        if (isFirst) {
            Log.e("isFirst", isFirst + "+isFirst");
            Toast.makeText(this, "isFirst=" + isFirst, Toast.LENGTH_LONG);
            sharedPreferences.edit().putBoolean("firstTime", false).commit();
//            try {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(WelcomeActivity.this, GuildActivity.class));
                    finish();
                }
            }, 3000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } else {
            Log.e("isFirst", isFirst + "+isFirst");
            Toast.makeText(this, "isFirst=" + isFirst, Toast.LENGTH_LONG);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.e("token", UserInfoUtil.getLoginToken() + "+token");
                    if (!TextUtils.isEmpty(UserInfoUtil.getLoginToken())) {
                        startActivity(new Intent(WelcomeActivity.this, MainsActivity.class));
                        finish();
                    } else {
                        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                        finish();
                    }
                }
            }, 3000);

        }
    }
}
