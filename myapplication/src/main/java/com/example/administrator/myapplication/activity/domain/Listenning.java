package com.example.administrator.myapplication.activity.domain;

/**
 * Created by 沙云杰 on 2016/5/10.
 */
public class Listenning {
    private String url;
    private String options;
    private String word;
    private String answer;
    private String title;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTitle(){
        return  title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
