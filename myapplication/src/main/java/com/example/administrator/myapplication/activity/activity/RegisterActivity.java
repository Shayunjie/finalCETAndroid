package com.example.administrator.myapplication.activity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.db.UserDb;


/**
 * Created by jz on 2016/3/22.
 */
public class RegisterActivity extends Activity{

    private EditText m_editTextUserName;
    private EditText m_editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        m_editTextUserName = (EditText) findViewById(R.id.tr_et_un);
        m_editTextPassword = (EditText) findViewById(R.id.tr_et_ps);

        findViewById(R.id.tr_btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userName = m_editTextUserName.getText().toString();
                final String password = m_editTextPassword.getText().toString();

                if(TextUtils.isEmpty(userName) ||
                        TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "不能有空选项", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!UserDb.isUserExist(RegisterActivity.this, userName)){
                    UserDb.insert(RegisterActivity.this,userName, password);
                }else{
                    Toast.makeText(RegisterActivity.this, "该用户名已被注册", Toast.LENGTH_SHORT).show();
                    return;
                }
//                try{
//                    UserDb.insert(RegisterActivity.this,userName, password);
//                }catch (Exception e){
//                    Toast.makeText(RegisterActivity.this, "该用户名已被注册", Toast.LENGTH_SHORT).show();
//                    return;
//                }


                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
