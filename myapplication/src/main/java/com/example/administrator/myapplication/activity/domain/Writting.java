package com.example.administrator.myapplication.activity.domain;

/**
 * Created by 沙云杰 on 2016/4/19.
 */
public class Writting {
    private String title;
    private String context;
    private String input;


    public Writting(){}

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }
}
