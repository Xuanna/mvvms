package com.example.xuchichi.scrollfloat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by xuchichi on 2017/2/13.
 */
public class ViewpagerAdapter extends FragmentPagerAdapter {
    public String titleStr[];
    List<Fragment> fragmentList;

    public ViewpagerAdapter(FragmentManager fm, String[] titleStr, List<Fragment> fragmentList) {
        super(fm);
        this.titleStr = titleStr;
        this.fragmentList = fragmentList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleStr[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
