package com.example.xuchichi.scrollfloat;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * Created by xuchichi on 2017/4/10.
 */
public class TextImageView extends RadioButton {

    private int width = 20;
    private int height = 20;
    int type;

    public TextImageView(Context context) {
        super(context,null);
    }

    public TextImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.TextImageView);
        width=a.getDimensionPixelSize(R.styleable.TextImageView_drawableWidth,width);
        height=a.getDimensionPixelSize(R.styleable.TextImageView_drawableHeight,height);
        Drawable drawable=a.getDrawable(R.styleable.TextImageView_drawable);
        type= a.getInt(R.styleable.TextImageView_positionType,1);
        a.recycle();
        if(type==1){
            setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
        }else if(type==2){
            setCompoundDrawablesWithIntrinsicBounds(null,drawable,null,null);
        }else if(type==3){
            setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null);
        }else if(type==4){
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,drawable);
        }
    }

    public TextImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        if (null != left) {
            left.setBounds(0, 0, width, height);
        }
        if (null != top) {
            top.setBounds(0, 0, width, height);
        }
        if (null != right) {
            right.setBounds(0, 0, width, height);
        }
        if (null != bottom) {
            bottom.setBounds(0, 0, width, height);
        }
        setCompoundDrawables(left, top, right, bottom);
    }
}
