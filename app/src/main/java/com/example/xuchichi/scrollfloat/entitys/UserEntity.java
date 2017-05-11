package com.example.xuchichi.scrollfloat.entitys;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.xuchichi.scrollfloat.activity.ListActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by xuchichi on 2017/5/8.
 */
public class UserEntity extends BaseObservable{
    private String username;
    private String nickname;
    private String imageUrl;
    private int age;
    Context context;

    public UserEntity() {
    }
    //綁定圖片
    @BindingAdapter("bind:imageUrl")
    public static void getInternetImage(ImageView iv,String imageUrl){
        Picasso.with(iv.getContext()).load(imageUrl).into(iv);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public UserEntity(String username, String nickname, String imageUrl, int age, Context context) {
        this.username = username;
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.age = age;
        this.context = context;
    }

    public void goListActivity(View view){
        Intent intent = new Intent(context, ListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
