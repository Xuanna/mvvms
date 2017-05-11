package com.example.xuchichi.scrollfloat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by xuchichi on 2017/3/21.
 */
public class Chat extends View {
    int width,height;
    double xDot[]={3.21,3.22,3.23,3.24,3.25};
    double yDot[]={200,300,400,500,600,700};

    Paint mPaintX,mPaintText,mPaintDot,mLine;
    Context mContext;

    public Chat(Context context) {
        super(context);
        width=getResources().getDisplayMetrics().widthPixels-80;
        height=getResources().getDisplayMetrics().heightPixels-812;
        Log.e("height","height:"+height);
        context=mContext;
    }

    public Chat(Context context, AttributeSet attrs) {
        super(context, attrs);
        width=getResources().getDisplayMetrics().widthPixels-80;
        height=getResources().getDisplayMetrics().heightPixels-1560;
        context=mContext;
    }

    public Chat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 画x，y轴
         */
        mPaintX=new Paint();
        mPaintX.setStrokeWidth(5);
        mPaintX.setColor(Color.BLUE);
        canvas.drawLine(100,width,width,width,mPaintX);
        canvas.drawLine(100,0,100,height,mPaintX);
        /**
         * 画X线上的点
         */
        mPaintDot=new Paint();
        mPaintDot.setStrokeWidth(5);
        mPaintDot.setColor(Color.YELLOW);
        int starXtPoint=width/5;
        float point[]={starXtPoint,height,starXtPoint*2,height,starXtPoint*3,height,starXtPoint*4,height,width,height};
        canvas.drawPoints(point,mPaintDot);
        mPaintText=new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setTextSize(25);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setColor(Color.BLACK);
        canvas.drawText("3.21",starXtPoint-10,height+20,mPaintText);
        canvas.drawText("3.22",starXtPoint*2-10,height+20,mPaintText);
        canvas.drawText("3.23",starXtPoint*3-10,height+20,mPaintText);
        canvas.drawText("3.24",starXtPoint*4-10,height+20,mPaintText);
        canvas.drawText("3.25",width-10,height+20,mPaintText);
        /**
         * 画y线上的点
         */
        int starYtPoint=height/5;
        float pointY[]={100,starYtPoint,100,starYtPoint*2,100,starYtPoint*3,100,starYtPoint*4,100,height};
        canvas.drawPoints(pointY,mPaintDot);
        canvas.drawText("600",70,starYtPoint,mPaintText);
        canvas.drawText("500",70,starYtPoint*2,mPaintText);
        canvas.drawText("400",70,starYtPoint*3,mPaintText);
        canvas.drawText("300",70,starYtPoint*4,mPaintText);
        canvas.drawText("200",70,height,mPaintText);
        /**
         * 画小圆
         */
        canvas.drawCircle(starXtPoint-10,starYtPoint*2,10,mPaintDot);
        canvas.drawCircle(starXtPoint*2-10,starYtPoint*4,10,mPaintDot);
        canvas.drawCircle(starXtPoint*3-10,starYtPoint*3,10,mPaintDot);
        canvas.drawCircle(starXtPoint*4-10,starYtPoint,10,mPaintDot);

        /**
         * 链接点
         */
        mLine=new Paint();
        mLine.setColor(Color.RED);
        mLine.setStyle(Paint.Style.STROKE);
//        Path path=new Path();
//        path.moveTo(starXtPoint-10,starYtPoint*2);
//        path.quadTo(100,starYtPoint*4,starXtPoint*2-10,starYtPoint*4);
//        canvas.drawPath(path,mPaintDot);

    }
    /**
     * 画X轴
     */
    public void drawX(){
        mPaintX=new Paint();
        mPaintX.setStrokeWidth(20);
        mPaintX.setColor(Color.BLUE);
    }
}
