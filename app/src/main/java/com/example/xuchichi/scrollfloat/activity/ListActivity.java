package com.example.xuchichi.scrollfloat.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.xuchichi.scrollfloat.BR;
import com.example.xuchichi.scrollfloat.R;
import com.example.xuchichi.scrollfloat.adapter.MyListAdapter;
import com.example.xuchichi.scrollfloat.entitys.FoodEnetity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ListActivity extends AppCompatActivity {
    List<FoodEnetity> foods;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv= (ListView) findViewById(R.id.lv);
        initData();
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            MyListAdapter<FoodEnetity> adapter = new MyListAdapter<>(ListActivity.this, R.layout.item_listview, BR.food , foods);
            lv.setAdapter(adapter);
        }
    };

    private void initData() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("http://www.tngou.net/api/food/list?id=1").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    parseJson(response.body().string());
                }
            }
        });
    }

    private void parseJson(String jsonStr) {
        foods = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(jsonStr);
            JSONArray tngou = jo.getJSONArray("tngou");
            for (int i = 0; i < tngou.length(); i++) {
                JSONObject item = tngou.getJSONObject(i);
                String description = item.getString("description");
                String img = "http://tnfs.tngou.net/image" + item.getString("img");
                String keywords = "【关键词】 " + item.getString("keywords");
                String summary = item.getString("summary");
                foods.add(new FoodEnetity(getApplicationContext(),img, description, keywords));
            }
            mHandler.sendEmptyMessage(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
