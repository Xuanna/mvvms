package com.example.xuchichi.scrollfloat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xuchichi.scrollfloat.adapter.MyRecycleViewAdapter;
import com.example.xuchichi.scrollfloat.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xuchichi on 2017/2/13.
 */
public class Fragment2 extends Fragment {
    View view;
    @Bind(R.id.recyeleView)
    RecyclerView recyeleView;
    MyRecycleViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, null);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    public void init() {
        recyeleView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true));
        adapter = new MyRecycleViewAdapter(getContext(), 2);
        recyeleView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
