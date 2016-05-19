package com.example.administrator.myapplication.activity;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 沙云杰 on 2016/5/4.
 */
public class MyApplication extends Application{
    public List<String> title= new ArrayList<>();
    public  List<Integer>score= new ArrayList<>();
    private static Context mContext;

    @Override
    public void onCreate(){
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }

    public void settList(List<String>mtitle){
        this.title = mtitle;
    }
    public List<String> gettList(){
        return title;
    }
    public void setiList(List<Integer>mscore){
        this.score = mscore;
    }
    public List<Integer> getiList(){
        return score;
    }
}
