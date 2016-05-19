package com.example.administrator.myapplication.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.activity.PullActivity;
import com.example.administrator.myapplication.activity.adapter.PullAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 沙云杰 on 2016/5/5.
 */
public class PullFragment extends Fragment{
    RecyclerView recyclerView;
    List<String> list = new ArrayList<>();
    String [] array = {"听力","选词","段落匹配","阅读理解","翻译","作文"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_pull,container,false);
        list.add("听力");
        list.add("选词");
        list.add("段落匹配");
        list.add("阅读理解");
        list.add("翻译");
        list.add("作文");
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_pull);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        PullAdapter adapter = new PullAdapter(list,getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new PullAdapter.OnClickItemListener() {
            @Override
            public void OnClickListener(View view,int position ) {
                Toast.makeText(getActivity().getApplicationContext(),"clicked"+list.get(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), PullActivity.class);
                switch (list.get(position)){
                    case "听力":
                        intent.putExtra("tag","a");
                        intent.putExtra("tablename","listenning");
                        break;
                    case "选词":
                        intent.putExtra("tag","a");
                        intent.putExtra("tablename","selectword");
                        break;
                    case "段落匹配":
                        intent.putExtra("tag","a");
                        intent.putExtra("tablename","long");
                        break;
                    case "阅读理解":
                        intent.putExtra("tag","a");
                        intent.putExtra("tablename","short");
                        break;
                    case "翻译":
                        intent.putExtra("tag","b");
                        intent.putExtra("tablename","translation");
                        break;
                    case "作文":
                        intent.putExtra("tag","b");
                        intent.putExtra("tablename","writting");
                        break;
                }
                startActivity(intent);
            }
        });
        return view;
    }

}
