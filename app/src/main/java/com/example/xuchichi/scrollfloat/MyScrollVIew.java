package com.example.xuchichi.scrollfloat;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by xuchichi on 2017/2/11.
 */
public class MyScrollVIew extends ScrollView {
    private ScrollViewListener scrollViewListener = null;
    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    public MyScrollVIew(Context context) {
        super(context);
    }

    public MyScrollVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollViewListener!=null){
            scrollViewListener.onScrollChanged(this,l, t, oldl, oldt);
        }
    }
}
