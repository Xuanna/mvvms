package com.example.xuchichi.scrollfloat;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xuchichi on 2017/3/24.
 */
public class CommonPopupWindow extends PopupWindow {
    Context mContext;
    ListView listview;
    ArrayList<String> arrayList;
    OutsideDismissListener outsideDismissListener;
    ListItemClick listItemClick;
    View view;

    public CommonPopupWindow(Context context, ArrayList<String> arrayList, final ListItemClick listItemClick) {
        super(context);
        mContext = context;
        this.arrayList = arrayList;
        this.listItemClick=listItemClick;
        view = LayoutInflater.from(mContext).inflate(R.layout.layout_common_pop, null);
        listview = (ListView) view.findViewById(R.id.listview);
        this.setContentView(view);
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        PopAdapter adapter = new PopAdapter();
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listItemClick.itemClick(parent,view,position,id);
            }
        });
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                outsideDismissListener.outSideDismiss();
            }
        });
    }

    public CommonPopupWindow(Context context, AttributeSet attrs, Context mContext, ArrayList<String> arrayList) {
        super(context, attrs);
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    public CommonPopupWindow(Context context, AttributeSet attrs, int defStyleAttr, Context mContext, ArrayList<String> arrayList) {
        super(context, attrs, defStyleAttr);
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    public void setOutsideDismissListener(OutsideDismissListener outsideDismissListener) {
        this.outsideDismissListener = outsideDismissListener;
    }

    public interface OutsideDismissListener {
        void outSideDismiss();
    }

    public class PopAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_textview, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv.setText(arrayList.get(position));
            return convertView;
        }

        class ViewHolder {
            @Bind(R.id.tv_)
            TextView tv;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
