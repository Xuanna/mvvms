package com.example.xuchichi.scrollfloat;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by xuchichi on 2017/2/14.
 */
public class Myservice extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public Myservice() {
    }
}
