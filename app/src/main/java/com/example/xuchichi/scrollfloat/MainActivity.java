package com.example.xuchichi.scrollfloat;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.xuchichi.scrollfloat.adapter.ViewpagerAdapter;
import com.example.xuchichi.scrollfloat.fragment.Fragment1;
import com.example.xuchichi.scrollfloat.fragment.Fragment2;
import com.example.xuchichi.scrollfloat.fragment.Fragment3;
import com.example.xuchichi.scrollfloat.fragment.Fragment4;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;

    ViewpagerAdapter viewpagerAdapter;
    String titleStr[] = {"fragment1", "fragment2","fragment3","fragment4"};
    List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }
    public void init() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());
        viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), titleStr, fragmentList);
        viewpager.setAdapter(viewpagerAdapter);
        tablayout.setLayoutMode(TabLayout.MODE_SCROLLABLE);
        tablayout.setupWithViewPager(viewpager);
    }
}
