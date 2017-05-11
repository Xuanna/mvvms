package com.example.xuchichi.scrollfloat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xuchichi.scrollfloat.MychatView;

/**
 * Created by xuchichi on 2017/3/21.
 */
public class Fragment3 extends Fragment{
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=new MychatView(getContext());
        return view;
    }
}
