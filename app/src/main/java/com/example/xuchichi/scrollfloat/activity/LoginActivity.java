package com.example.xuchichi.scrollfloat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xuchichi.scrollfloat.Myapplication;
import com.example.xuchichi.scrollfloat.R;
import com.example.xuchichi.scrollfloat.entitys.UserInfoUtil;
import com.example.xuchichi.scrollfloat.entitys.UserIno;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.btn_login)
    Button btnLogin;

    String username, passward;


    OkHttpClient client = new OkHttpClient();
    public String loginUrl = "http://wallet.pigamegroup.com/user/applogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    /**
     * 登陆
     *
     * @param url
     * @return
     * @throws IOException
     */
    void login(String url) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("username", etUsername.getText().toString())
                .add("password", etPwd.getText().toString()).build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(LoginActivity.this, "failed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }
                Gson gson=new Gson();
             UserIno userIno=gson.fromJson(response.body().string(), UserIno.class);
                if(userIno.status.equalsIgnoreCase("success")){
                    UserInfoUtil.saveLoginToken(userIno.data.appLoginToken);
                    startActivity(new Intent(LoginActivity.this,MainsActivity.class));
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),userIno.status,Toast.LENGTH_SHORT).show();
                }
//                gson.toJson(response.body().string());
//                System.out.println(response.body().string());
            }
        });
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        try {
            login(loginUrl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
