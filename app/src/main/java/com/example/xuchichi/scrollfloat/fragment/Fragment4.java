package com.example.xuchichi.scrollfloat.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.example.xuchichi.scrollfloat.R;
import com.example.xuchichi.scrollfloat.activity.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xuchichi on 2017/3/23.
 * 属性动画的使用
 */
public class Fragment4 extends Fragment {
    View view;
    @Bind(R.id.iv_image)
    ImageView ivImage;
    @Bind(R.id.iv_progress)
    ImageView ivProgress;
    int height, width;
    @Bind(R.id.btn_)
    Button btn;
    @Bind(R.id.vf)
    ViewFlipper vf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment4, null);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public void initView() {
        vf.addView(View.inflate(getContext(),R.layout.layout_view_fille,null));
        vf.addView(View.inflate(getContext(),R.layout.layout_view_fille2,null));
//        vf.setAutoStart(true);
        vf.setFlipInterval(1000);
        String url = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1694940474,3473791221&fm=23&gp=0.jpg";
        Glide.with(getActivity()).load(url)
                .transform(new CircleTransform(getActivity()))
                .into(ivImage);
        height = getResources().getDisplayMetrics().heightPixels;
        width = getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public static class CircleTransform extends BitmapTransformation {
        public CircleTransform(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private static Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            // TODO this could be acquired from the pool too
            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }

    @OnClick(R.id.btn_)
    public void onClick() {
        startActivity(new Intent(getContext(), LoginActivity.class));
//        valueAnimator();
    }

    public void valueAnimator() {
        int RED = 0xffFF8080;
        int BLUE = 0xff8080FF;
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(btn, "backgroundColor", RED, BLUE);
//        ValueAnimator valueAnimator=ValueAnimator.ofInt(0x3ef3ed,0xFF0000);
        valueAnimator.setDuration(500);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setTarget(btn);
        valueAnimator.start();
    }
}
