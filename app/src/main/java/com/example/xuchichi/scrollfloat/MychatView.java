package com.example.xuchichi.scrollfloat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by xuchichi on 2017/3/22.
 */
public class MychatView extends View {
    int widthX, heightY, width, height;//坐标x,y的长度，屏幕的长宽

    Paint axisPaint, dotPaint,textPaint;//坐標軸，小圓點和线
    Context mContext;
    float density;

    float xValue[], yValue[];


    public MychatView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public MychatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public MychatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView() {
        density = getResources().getDisplayMetrics().density;
        widthX = mContext.getResources().getDisplayMetrics().widthPixels - dp2px(40);
        heightY = dp2px(200);

    }

    public int px2dp(int pxValue) {
        return (int) (pxValue / density + 0.5f);
    }

    /**
     * dp转成px
     *
     * @param dpValue
     * @return
     */
    public int dp2px(int dpValue) {
        return (int) (dpValue * density + 0.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        axisPaint = new Paint();
        axisPaint.setColor(Color.BLUE);
        axisPaint.setStrokeWidth(dp2px(2));
        canvas.translate(dp2px(20), dp2px(300));
        /**
         * 画x轴
         */
        canvas.drawLine(0, 0, widthX, 0, axisPaint);
        /**
         * 画y轴
         */
        canvas.drawLine(0, 0, 0, -(dp2px(200)), axisPaint);

        dotPaint = new Paint();
        dotPaint.setColor(Color.YELLOW);
        dotPaint.setStyle(Paint.Style.STROKE);
        dotPaint.setStrokeWidth(dp2px(1));
        /**
         * 画x轴上的点
         */
        int everyX = widthX / 5;
        xValue = new float[]{everyX, 0, everyX * 2, 0, everyX * 3, 0, everyX * 4, 0, widthX, 0};
//        canvas.drawPoints(xValue, dotPaint);
        /**
         * 画y轴上的点
         */
        int everyY = dp2px(200) / 5;
        yValue = new float[]{0, -everyY, 0, -everyY * 2, 0, -everyY * 3, 0, -everyY * 4, 0, -dp2px(200)};
//        canvas.drawPoints(yValue, dotPaint);
        /**
         * 给x轴上的位置赋值
         */
        textPaint=new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(20);
        textPaint.setTextAlign(Paint.Align.CENTER);
        float x[]={everyX,everyX*2,everyX*3,everyX*4,widthX};
        String xText[]={"3.22","3.23","3.24","3.25","3.26"};
        for (int i = xText.length - 1; i >= 0; i--) {
            canvas.drawText(xText[i],x[i],dp2px(10),textPaint);
        }
        /**
         * 给y轴上的位置赋值
         */
        float y[]={-everyY,-everyY*2,-everyY*3,-everyY*4,-dp2px(200)};
        String yText[]={"300","400","500","600","700"};
        for (int i = yText.length - 1; i >= 0; i--) {
            canvas.drawText(yText[i],-dp2px(10),y[i],textPaint);
        }
        /**
         * 画小圆点
         */
        int circleY[]={-everyY*2,-everyY,-dp2px(200),-everyY*4,-everyY*3};
        for (int i = 0; i < circleY.length; i++) {
            canvas.drawCircle(x[i],circleY[i],dp2px(2),dotPaint);
        }
        /**
         * 连接小圆点的弧线
         */
        RectF rectf=new RectF(everyX,-everyY*2,everyX*2,-everyY);
        canvas.drawArc(rectf,45,-180,true,dotPaint);

        super.onDraw(canvas);
    }
}
