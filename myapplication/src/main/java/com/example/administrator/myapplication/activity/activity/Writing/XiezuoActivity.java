package com.example.administrator.myapplication.activity.activity.Writing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.activity.NavigationActivity;
import com.example.administrator.myapplication.activity.db.DBManager;

/**
 * Created by 沙云杰 on 2016/4/19.
 *写作考试界面：包含了题目，输入框和提交按钮
 *
 */
public class XiezuoActivity extends Activity {
    TextView textView;
    EditText editText;
    int i;
    String context;
    String input;
    DBManager  dbManager;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiezuo);
        dbManager= new DBManager(this);
        textView = (TextView)findViewById(R.id.tv_xiezuo);
        editText = (EditText)findViewById(R.id.ed_xiezuo);
        button = (Button)findViewById(R.id.bt_tj);
        getintent();
        settext();
        editText.setText(input);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEditor();
                Intent intent = new Intent();
                intent.setClass(XiezuoActivity.this,NavigationActivity.class);
                startActivity(intent);
            }
        });
    }
    void getintent(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        i = bundle.getInt("id");
        context = bundle.getString("context");
        input = bundle.getString("input");
    }
     void settext() {
         textView.setText(context);
    }
     void saveEditor(){
         input = editText.getText().toString();
         dbManager.update("Writting", input, i);
    }
}
