package com.example.administrator.myapplication.activity.activity.LongRead;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

/**
 * Created by 沙云杰 on 2016/5/5.
 * 将从activit中传来的数据中的context部分setText()到当前页面
 */
public class ListenOptFragment extends Fragment {
    TextView textView;
    String context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_test,container,false);
        textView = (TextView)view.findViewById(R.id.tv_fra);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        initData();
        textView.setText(context);
        return view;
    }
    void initData(){
        if(getArguments()!=null) {
            context = getArguments().getString("options");
        }else{
            Toast.makeText(getActivity(),"getArguments is null",Toast.LENGTH_LONG).show();
        }
//        Bundle bundle = getArguments();
//        context = bundle.getString("context");
    }


}
