package com.example.xuchichi.scrollfloat.entitys;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import com.example.xuchichi.scrollfloat.BR;
import com.example.xuchichi.scrollfloat.activity.ItemDetailActivity;
import com.example.xuchichi.scrollfloat.activity.NewListActivity;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

/**
 * Created by xuchichi on 2017/5/8.
 */
public class FoodEnetity extends BaseObservable implements Parcelable{
    public String foodImage;
    public String describe;
    public String keyWord;
    public Context context;

    public FoodEnetity() {
    }

    public FoodEnetity(Context context, String foodImage, String describe, String keyWord) {
        this.foodImage = foodImage;
        this.describe = describe;
        this.keyWord = keyWord;
        this.context=context;
    }
    //写入接口函数，打包
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(foodImage);
        dest.writeString(describe);
        dest.writeString(keyWord);
    }

    //内容描述接口，基本不用管
    @Override
    public int describeContents() {
        return 0;
    }
    public FoodEnetity(Parcel source) {
        foodImage = source.readString();
        describe=source.readString();
        keyWord = source.readString();
    }
    public static  Creator<FoodEnetity> CREATOR=new Creator<FoodEnetity>() {
        /**
         * 从Parcel中读取数据
         */
        @Override
        public FoodEnetity createFromParcel(Parcel source) {
            return new FoodEnetity(source);
        }

        /**
         * 供外部类反序列化本类数组使用
         */
        @Override
        public FoodEnetity[] newArray(int size) {
            return new FoodEnetity[size];
        }
    };
    @Override
    public String toString() {
        return "FoodEnetity{" +
                "foodImage='" + foodImage + '\'' +
                ", describe='" + describe + '\'' +
                ", keyWord='" + keyWord + '\'' +
                '}';
    }

    @BindingAdapter("bind:foodImage")
    public static  void bindImage(ImageView view,String foodImage){
        Picasso.with(view.getContext()).load(foodImage).into(view);
    }
    public void onitemClick(View view){
        Intent intent=new Intent(context, ItemDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("foodEntity",FoodEnetity.this);
        context.startActivity(intent);

    }

    @Bindable
    public String getFoodImage() {
        return foodImage;
    }
    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
        notifyPropertyChanged(BR.foodImage);
    }
    @Bindable
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
        notifyPropertyChanged(BR.describe);
    }

    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
