package com.example.administrator.myapplication.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.db.UserDb;


public class LoginActivity extends AppCompatActivity {

    private EditText m_editTextUsername;
    private EditText m_editTextPassword;
//    private RadioGroup m_radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    public void initView() {

        m_editTextUsername = (EditText) findViewById(R.id.tl_et_un);
        m_editTextPassword = (EditText) findViewById(R.id.tl_et_ps);
//        m_radioGroup = (RadioGroup)findViewById(R.id.tl_rg_group);
        findViewById(R.id.tl_btn_login).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String userName = m_editTextPassword.getText().toString();
                final String passWord = m_editTextUsername.getText().toString();

                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
                    Toast.makeText(LoginActivity.this, "不能有空白项", Toast.LENGTH_SHORT).show();
                    return;

                }else if ( UserDb.login(LoginActivity.this, userName, passWord)){
                    Intent intent = new Intent(LoginActivity.this,NavigationActivity.class);
                    intent.putExtra("userName",userName);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "用户名或密码错误!", Toast.LENGTH_SHORT).show();
                }
            }

        });

                findViewById(R.id.tl_et_register).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                        startActivity(intent);
                    }
                });


    }
}
