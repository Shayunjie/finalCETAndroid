package com.example.administrator.myapplication.activity.domain;

/**
 * Created by 沙云杰 on 2016/4/20.
 * 阅读理解的题目和正确选项
 */
public class ShortReading {
    private String title;
    private String context;
    private String answer;
    private String options;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer1) {
        this.answer = answer1;
    }



    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
