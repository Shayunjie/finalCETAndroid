package com.example.administrator.myapplication.activity.activity.LongRead;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.adapter.RViewPageAdapter;

/**
 * Created by 沙云杰 on 2016/5/5.
 */
public class ListenningActivity extends AppCompatActivity {
    ViewPager viewPager;
    public String answer;
    public String url;
    public String options;
    public String word;
    public MediaPlayer player;
    ListenAnsFragment fragment1 ;
    ListenOptFragment fragment ;
  //Todo  String[] word = word.split(" ");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.include_page_read);
        initIntent();
        initView();
        initMedia();
    }
    public void initMedia(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    player = new MediaPlayer();
                    //获取音乐路径
                    String path = url;
                    //给播放器设置音乐路径
                    player.setDataSource(path);
                    //设置音乐格式
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    //准备
                    player.prepare();
                    //音乐开始播放
                    player.start();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void initIntent(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bundle.putString("tablename","listenning");
        options = bundle.getString("options",options);
        url = bundle.getString("url",url);
        word = bundle.getString("word",word);
        answer = bundle.getString("answer",answer);
        fragment1 = new ListenAnsFragment();
        fragment = new ListenOptFragment();
        fragment1.setArguments(bundle);
        fragment.setArguments(bundle);
    }
    void initView(){
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    void setupViewPager(ViewPager viewPager){
        RViewPageAdapter adapter = new RViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(fragment, "试题");
        adapter.addFragment(fragment1, "选项");
        viewPager.setAdapter(adapter);
    }
}
