package com.example.xuchichi.scrollfloat;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @Bind(R.id.tv)
    TextView tv;
    SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_);
        ButterKnife.bind(this);
        init();
    }
    String timeStr;
    long time;
    public void init() {
        handler.postDelayed(runnable,1000);
        time=System.currentTimeMillis();
        timeStr=dateFormat.format(new Date(time));
        tv.setText(timeStr);
        acquireWakeLock();
    }
    // 申请电源锁，禁止休眠
    private PowerManager.WakeLock mWakeLock = null;

    private void acquireWakeLock() {
        if (null == mWakeLock) {
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, this
                    .getClass().getCanonicalName());
            if (null != mWakeLock) {
                mWakeLock.acquire();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseWakeLock();
    }

    // 释放设备电源锁
    private void releaseWakeLock() {
        if (null != mWakeLock) {
            mWakeLock.release();
            mWakeLock = null;
        }
    }
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            time=time+1000;
            timeStr=dateFormat.format(new Date(time));
            tv.setText(timeStr);
            handler.postDelayed(runnable,1000);
        }
    };
}
