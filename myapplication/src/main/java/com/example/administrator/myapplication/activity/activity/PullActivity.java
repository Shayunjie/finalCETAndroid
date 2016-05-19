package com.example.administrator.myapplication.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.db.DBManager;

/**
 * Created by 沙云杰 on 2016/5/5.
 */
public class PullActivity extends Activity {
    EditText et1;
    EditText et2;
    EditText et3,et4;
    FloatingActionButton button;
    String title,context,answer,options,choose;
    String TABLENAME ;
    DBManager db;
    String tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_pull);
        et1 = (EditText)findViewById(R.id.et_pull_title);
        et2 = (EditText)findViewById(R.id.et_pull_context);
        et3 = (EditText)findViewById(R.id.et_pull_answer);
        et4 = (EditText)findViewById(R.id.et_pull_options);
        button = (FloatingActionButton)findViewById(R.id.fab_act_pull);
        db = new DBManager(this);

        Intent intent = getIntent();
        tag = intent.getStringExtra("tag");
        TABLENAME = intent.getStringExtra("tablename");
        Toast.makeText(PullActivity.this,TABLENAME,Toast.LENGTH_SHORT).show();
        if(tag.equals("a")){
            initView();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        db.insert(TABLENAME,title,context,options,answer);
                    Intent intent = new Intent(PullActivity.this,NavigationActivity.class);
                    startActivity(intent);
                }
            });
        }else{
            inshowView();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        db.insert(TABLENAME, title, context);
                    Intent intent = new Intent(PullActivity.this,NavigationActivity.class);
                    startActivity(intent);
                }
            });
        }

    }
    void initView(){
//        Intent intent = getIntent();
//        final String tableName = intent.getStringExtra("tableName");
        title = et1.getText().toString();
        context = et2.getText().toString();
        choose = et3.getText().toString();
        options = et4.getText().toString();
        StringBuffer sb = new StringBuffer();
        if (choose != null) {
            for (int i = 0; i < choose.length(); i++) {
                char c = choose.charAt(i);
                if (Character.isLowerCase(c)) {
                    sb.append(Character.toUpperCase(c));
                }
            }
        }
        answer = sb.toString();
    }

    void inshowView(){
        et3.setVisibility(View.GONE);
        et4.setVisibility(View.GONE);
        title = et1.getText().toString();
        context = et2.getText().toString();
    }

}
