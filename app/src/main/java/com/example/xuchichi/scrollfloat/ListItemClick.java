package com.example.xuchichi.scrollfloat;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by xuchichi on 2017/3/25.
 */
public interface ListItemClick {
    void itemClick(AdapterView<?> parent, View view, int position, long id);
}
