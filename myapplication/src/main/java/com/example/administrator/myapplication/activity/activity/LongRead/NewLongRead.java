package com.example.administrator.myapplication.activity.activity.LongRead;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.adapter.RViewPageAdapter;

/**
 * Created by 沙云杰 on 2016/5/5.
 */
public class NewLongRead extends AppCompatActivity {
    ViewPager viewPager;
    public String answer;
    public String context;
    public String options;
    TestFragment fragment ;
    SelectFragment fragment1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.include_page_read);
        initIntent();
        initView();
    }
    public void initIntent(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bundle.putString("tablename","long");
        options = bundle.getString("options",options);
        context = bundle.getString("context",context);
        answer = bundle.getString("answer",answer);
        Log.d("------------",context);
        fragment = new TestFragment();
        fragment1 = new SelectFragment();
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
