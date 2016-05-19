package com.example.administrator.myapplication.activity.activity.LongRead;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.InputLowerToUpper;
import com.example.administrator.myapplication.activity.activity.NavigationActivity;
import com.example.administrator.myapplication.activity.db.DBManager;

/**
 * Created by 沙云杰 on 2016/5/5.
 */
public class SelectFragment extends Fragment {
    EditText editText;
    TextView textView;
    TextView tv;
    FloatingActionButton button;
    FloatingActionButton _button;
    String options;
    String answer;
    String tablename;
    String title;
    int score;
    DBManager dbManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_selest,container,false);
        dbManager = new DBManager(getActivity());
        textView=(TextView)view.findViewById(R.id.tv_fra_select);
        editText=(EditText)view.findViewById(R.id.et_fra_select);
        //lower char translate to upper
        editText.setTransformationMethod(new InputLowerToUpper());
        tv = (TextView)view.findViewById(R.id.tv_fra_answer);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        tv.setText("");
        button=(FloatingActionButton)view.findViewById(R.id.fab_act_select);
        _button=(FloatingActionButton)view.findViewById(R.id.fab_act_submit);
        _button.setVisibility(View.GONE);
        if(getArguments()!=null) {
            Bundle bundle = getArguments();
            title = bundle.getString("title");
            options = bundle.getString("options");
            answer = bundle.getString("answer");
            tablename = bundle.getString("tablename");
            textView.setText(options);
        }
        if(answer.length()==5){
            InputFilter[] filters = {new InputFilter.LengthFilter(5)};
            editText.setFilters(filters);
        }else {
            InputFilter[] filters = {new InputFilter.LengthFilter(10)};
            editText.setFilters(filters);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choose = editText.getText().toString();
                Log.d("------",choose);
                StringBuffer sb = new StringBuffer();
                if(choose!=null){
                    for(int i=0;i<choose.length();i++){
                        char c = choose.charAt(i);
                        if(Character.isLowerCase(c)){
                            sb.append(Character.toUpperCase(c));
                        }
                    }
                }

//                sb.toString();
//                //               List<Integer> list = new ArrayList<Integer>();
                char[] a1 = sb.toString().toCharArray();
                Log.d("------",sb.toString());
                char[] b1 = answer.toCharArray();
                if (a1.length < answer.length()) {
                    Toast.makeText(getActivity(), "输入答案少于题数，请核对后确认", Toast.LENGTH_LONG).show();
                } else {
                    int j = 0;
                    for (int i = 0; i < a1.length; i++) {
                        if (a1[i] == b1[i]) {
                            score = ++j;
                        }
                    }
                    tv.setText("您的得分为：" + j+ "请再接再厉！\n" +
                            "正确答案是：" + answer);
                    button.setVisibility(View.GONE);
                    _button.setVisibility(view.VISIBLE);
                    saveScore(j);
                }
            }
        });
        _button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NavigationActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    void saveScore(int score){
        dbManager.insert(tablename,title,score);
    }
}
