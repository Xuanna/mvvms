package com.example.xuchichi.scrollfloat;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;


/**
 * @author: zhangxin
 * @time: 2016/7/28 15:03
 * @description: 自定义radioButton
 */
public class MyRadioButton extends RadioButton {

    private int width = 20;
    private int height = 20;


    public MyRadioButton(Context context) {
        this(context, null);
    }

    public MyRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyRadioButton);
        width = a.getDimensionPixelSize(R.styleable.MyRadioButton_rbDrawableWidth, width);
        height = a.getDimensionPixelSize(R.styleable.MyRadioButton_rbDrawableHeight, height);
        Drawable drawableLeft = a.getDrawable(R.styleable.MyRadioButton_rbDrawableLeft);
        a.recycle();
        setCompoundDrawablesWithIntrinsicBounds(drawableLeft, null, null, null);
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        if (null != left) {
            left.setBounds(0, 0, width, height);
        }
        if (null != right) {
            right.setBounds(0, 0, width, height);
        }

        if (null != top) {
            top.setBounds(0, 0, width, height);
        }

        if (null != bottom) {
            bottom.setBounds(0, 0, width, height);
        }
        setCompoundDrawables(left, top, right, bottom);
    }
}
