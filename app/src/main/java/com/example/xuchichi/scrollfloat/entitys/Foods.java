package com.example.xuchichi.scrollfloat.entitys;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.ImageView;

import com.example.xuchichi.scrollfloat.BR;
import com.squareup.picasso.Picasso;

/**
 * Created by xuchichi on 2017/5/10.
 */
public class Foods extends BaseObservable {
    private final ObservableField<String> describe = new ObservableField<>();
    private final ObservableField<String> Image = new ObservableField<>();
    private final ObservableField<String> keyWord = new ObservableField<>();

    public Foods() {
    }
    public Foods(String describe, String foodImage, String keyWord) {
        this.describe.set(describe);
        this.Image.set(foodImage);
        this.keyWord.set(keyWord);
    }
    @BindingAdapter("bind:Image")
    public static  void Image(ImageView view, String foodImage){
        Picasso.with(view.getContext()).load(foodImage).into(view);
    }
    public void onitemClick(View view){
        setDescribe("111");
//        Toast.makeText(view.getContext(),toString(),Toast.LENGTH_SHORT).show();
    }

    public void setDescribe(String describe){
        this.describe.set(describe);
        notifyPropertyChanged(BR.describe);
    }
    @Bindable
    public String getDescribe(){
        return describe.get();
    }
    public void sefoodImage(String foodImage){
        this.Image.set(foodImage);
    }
    public String getfoodImage(){
        return describe.get();
    }
    public void setkeyWord(String keyWord){
        this.keyWord.set(keyWord);
    }
    public String getkeyWord(){
        return keyWord.get();
    }
}
