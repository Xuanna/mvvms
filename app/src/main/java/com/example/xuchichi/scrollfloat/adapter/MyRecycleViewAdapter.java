package com.example.xuchichi.scrollfloat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xuchichi.scrollfloat.R;

/**
 * Created by xuchichi on 2017/3/21.
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.Myholder> {
    Context context;
    int type;

    public MyRecycleViewAdapter(Context context, int type) {
        this.context = context;
        this.type = type;
    }

    public MyRecycleViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        if (type == 1) {
            view = LayoutInflater.from(context).inflate(R.layout.item_recycle, null);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_recycle2, null);
        }

        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
//       ViewGroup.LayoutParams params= holder.tvText.getLayoutParams();
        if (type == 1) {
            holder.tvText.setText("我是第" + position + "個textview，哈哈哈啊哈");
        }

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class Myholder extends RecyclerView.ViewHolder {
//        @Bind(R.id.tv_text)
        TextView tvText;

        public Myholder(View itemView) {
            super(itemView);
            tvText= (TextView) itemView.findViewById(R.id.tv_text);
        }
    }
}
