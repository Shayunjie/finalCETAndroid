package com.example.administrator.myapplication.activity.activity.LongRead;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.activity.NavigationActivity;
import com.example.administrator.myapplication.activity.db.DBManager;

/**
 * Created by 沙云杰 on 2016/5/5.
 */
public class ListenAnsFragment extends Fragment {
    TextView tv;
    FloatingActionButton button;
    FloatingActionButton _button;
    String answer;
    String words;
    String tablename;
    String title;
    int score1;
    int score2;
    int score;
    DBManager dbManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_listen_answer,container,false);
        dbManager = new DBManager(getActivity());

        tv= (TextView)view.findViewById(R.id.tv_listen_answer);
        tv.setText("");
       final EditText AnsEt1 = (EditText)view. findViewById(R.id.et_ans_1);
        final EditText AnsEt2 = (EditText)view. findViewById(R.id.et_ans_2);
        final EditText AnsEt3 = (EditText)view. findViewById(R.id.et_ans_3);
        final EditText AnsEt4 = (EditText)view. findViewById(R.id.et_ans_4);
        final EditText AnsEt5 = (EditText)view. findViewById(R.id.et_ans_5);

        final EditText WordEt1 = (EditText)view. findViewById(R.id.et_word_1);
        final EditText WordEt2 = (EditText)view. findViewById(R.id.et_word_2);
        final EditText WordEt3 = (EditText)view. findViewById(R.id.et_word_3);
        final EditText WordEt4 = (EditText)view. findViewById(R.id.et_word_4);
        final EditText WordEt5 = (EditText)view. findViewById(R.id.et_word_5);
        final EditText WordEt6 = (EditText)view. findViewById(R.id.et_word_6);
        final EditText WordEt7 = (EditText)view. findViewById(R.id.et_word_7);
        final EditText WordEt8 = (EditText)view. findViewById(R.id.et_word_8);
        final EditText WordEt9 = (EditText)view. findViewById(R.id.et_word_9);
        final EditText WordEt10 = (EditText)view. findViewById(R.id.et_word_10);
        final EditText WordEt11= (EditText)view. findViewById(R.id.et_word_11);
        final EditText WordEt12 = (EditText)view. findViewById(R.id.et_word_12);
        final EditText WordEt13 = (EditText)view. findViewById(R.id.et_word_13);
        final EditText WordEt14 = (EditText)view. findViewById(R.id.et_word_14);
        final EditText WordEt15 = (EditText)view. findViewById(R.id.et_word_15);
        final EditText WordEt16 = (EditText)view. findViewById(R.id.et_word_16);
        final EditText WordEt17 = (EditText)view. findViewById(R.id.et_word_17);
        final EditText WordEt18 = (EditText)view. findViewById(R.id.et_word_18);
        final EditText WordEt19 = (EditText)view. findViewById(R.id.et_word_19);
        final EditText WordEt20 = (EditText)view. findViewById(R.id.et_word_20);




        button=(FloatingActionButton)view.findViewById(R.id.fab_listen_select);
        _button=(FloatingActionButton)view.findViewById(R.id.fab_listen_submit);
        _button.setVisibility(View.GONE);
        if(getArguments()!=null) {
            Bundle bundle = getArguments();
            title = bundle.getString("title");
            words = bundle.getString("word");
            answer = bundle.getString("answer");
            tablename = bundle.getString("tablename");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String one = AnsEt1.getText().toString();
                String two = AnsEt2.getText().toString();
                String three = AnsEt3.getText().toString();
                String four = AnsEt4.getText().toString();
                String five = AnsEt5.getText().toString();

                String word1 = WordEt1.getText().toString();
                String word2 = WordEt2.getText().toString();
                String word3 = WordEt3.getText().toString();
                String word4 = WordEt4.getText().toString();
                String word5 = WordEt5.getText().toString();
                String word6 = WordEt6.getText().toString();
                String word7 = WordEt7.getText().toString();
                String word8 = WordEt8.getText().toString();
                String word9 = WordEt9.getText().toString();
                String word10 = WordEt10.getText().toString();
                String word11 = WordEt11.getText().toString();
                String word12 = WordEt12.getText().toString();
                String word13 = WordEt13.getText().toString();
                String word14 = WordEt14.getText().toString();
                String word15 = WordEt15.getText().toString();
                String word16 = WordEt16.getText().toString();
                String word17 = WordEt17.getText().toString();
                String word18 = WordEt18.getText().toString();
                String word19 = WordEt19.getText().toString();
                String word20 = WordEt20.getText().toString();

                StringBuffer choose = new StringBuffer();
                choose.append(one);
                choose.append(two);
                choose.append(three);
                choose.append(four);
                choose.append(five);
                StringBuffer sb = new StringBuffer();
                if(choose!=null){
                    for(int i=0;i<choose.length();i++){
                        char c = choose.charAt(i);
                        if(Character.isLowerCase(c)){
                            sb.append(Character.toUpperCase(c));
                        }
                    }
                }

                char[] a1 = sb.toString().toCharArray();
                Log.d("------",sb.toString());
                char[] b1 = answer.toCharArray();
                if (one.length()<5||two.length()<5||three.length()<5||four.length()<5||five.length()<5) {
                    Toast.makeText(getActivity(), "输入答案少于题数，请核对后确认", Toast.LENGTH_LONG).show();
                } else {
                    int j = 0;
                    for (int i = 0; i < a1.length; i++) {
                        if (a1[i] == b1[i]) {
                            score1 = ++j;
                        }
                    }
                    String [] word = words.split(" ");
                    String []select = {word1,word2,word3,word4,word5,word6,word7,word8,
                            word9,word10,word11,word12,word13,word14,word15,word16,word17,word18,
                            word19,word20};
                    int h = 0;
                    for(int i = 0;i<word.length;i++){
                        if (word[i]==select[i]){
                            ++h;
                            score2 = (++h)/2;
                        }
                    }
                    score = score1+score2;
                    tv.setText("您的得分为：" + score+ "请再接再厉！\n" +
                            "正确答案是：" + answer+"   "+words);
                    button.setVisibility(View.GONE);
                    _button.setVisibility(view.VISIBLE);
                    saveScore(score);
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
