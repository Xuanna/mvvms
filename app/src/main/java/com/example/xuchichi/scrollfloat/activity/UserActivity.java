package com.example.xuchichi.scrollfloat.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.xuchichi.scrollfloat.BR;
import com.example.xuchichi.scrollfloat.R;
import com.example.xuchichi.scrollfloat.databinding.UserLayoutBinding;
import com.example.xuchichi.scrollfloat.entitys.UserEntity;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       UserLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.user_layout);
        UserEntity user = new UserEntity();
        user.setAge(2);

        user.setUsername("zhangsan");
        user.setNickname("张三");
        user.setImageUrl("http://img2.cache.netease.com/auto/2016/7/28/201607282215432cd8a.jpg");
        user.setContext(getApplicationContext());
        binding.setUser(user);
//        binding.setVariable(BR.user,user);
    }
}
