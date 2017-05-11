package com.example.xuchichi.scrollfloat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xuchichi.scrollfloat.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GuildActivity extends AppCompatActivity {

    @Bind(R.id.iv_viewpager)
    ViewPager ivViewpager;

    int color[] = {0x3ef3ed, 0xffffff, 0x666666, 0x111111, 0xff0000};
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guild);
        ButterKnife.bind(this);
        initViewpager();
        init();
    }

    public void init() {
        ivViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("Scrolled", "position=" + position + "=length=" + (color.length - 1));
                if (position == color.length - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(GuildActivity.this, LoginActivity.class));
                            finish();
                        }
                    }, 3000);
                }
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("position", "position=" + position + "=length=" + (color.length - 1));
                if (position == color.length - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(GuildActivity.this, LoginActivity.class));
                            finish();
                        }
                    }, 3000);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void initViewpager() {
        adapter = new ImageAdapter(color, this);
        ivViewpager.setAdapter(adapter);
    }

    public class ImageAdapter extends PagerAdapter {
        int color[];
        Context context;

        public ImageAdapter(int[] color, Context context) {
            this.color = color;
            this.context = context;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView iv = new TextView(context);
            iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            iv.setBackgroundColor(color[position]);
            iv.setText("Viewpager" + position);
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return color.length - 1;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
