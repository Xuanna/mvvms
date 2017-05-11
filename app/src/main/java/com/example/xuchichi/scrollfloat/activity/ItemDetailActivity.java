package com.example.xuchichi.scrollfloat.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.xuchichi.scrollfloat.BR;
import com.example.xuchichi.scrollfloat.R;
import com.example.xuchichi.scrollfloat.databinding.ItemListviewBinding;
import com.example.xuchichi.scrollfloat.entitys.FoodEnetity;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_item_detail);
        FoodEnetity foodEnetity = getIntent().getParcelableExtra("foodEntity");
//        String foodImag = getIntent().getStringExtra("foodImage");
//        String describe = getIntent().getStringExtra("describe");
//        String keyWord = getIntent().getStringExtra("keyWord");
//        FoodEnetity foodEnetity = new FoodEnetity();
//        foodEnetity.setDescribe(describe);
//        foodEnetity.setKeyWord(keyWord);
//        foodEnetity.setFoodImage(foodImag);
//        FoodEnetity foodEnetity = new FoodEnetity(getApplicationContext(), foodImag, describe, keyWord);
        dataBinding.setVariable(BR.foods, foodEnetity);
    }
}
