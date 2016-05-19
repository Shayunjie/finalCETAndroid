package com.example.administrator.myapplication.activity.domain;

import java.io.Serializable;

/**
 * Created by 沙云杰 on 2016/5/9.
 */
public class Score implements Serializable{
    private String tablename;
    private String title;
    private int score;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
