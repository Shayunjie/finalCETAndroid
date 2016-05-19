package com.example.administrator.myapplication.activity.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.activity.ChartActivity;
import com.example.administrator.myapplication.activity.adapter.PullAdapter;
import com.example.administrator.myapplication.activity.db.DBManager;
import com.example.administrator.myapplication.activity.domain.Score;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 沙云杰 on 2016/5/5.
 */
public class ChartFragment extends Fragment implements Serializable{
    Button button;
    public ArrayList<String> title= new ArrayList<>();
    public ArrayList<Integer>score= new ArrayList<>();
    List<Score> lr = new ArrayList<>();

    DBManager dbManager;
    private String tablename;
    RecyclerView recyclerView;
    List<String> list = new ArrayList<>();
    String [] array = {"听力","选词","段落匹配","阅读理解","翻译","作文"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_pull,container,false);
        initData();
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

                switch (list.get(position)){
                    case "听力":
                        tablename="listenning";
                        break;
                    case "选词":
                        tablename="selectword";
                        break;
                    case "段落匹配":
                        tablename = "long";
                        break;
                    case "阅读理解":
                        tablename = "short";
                        break;
                    case "翻译":
                        tablename = "traslation";
                        break;
                    case "作文":
                        tablename = "writting";
                        break;
                }
                initData();
                Intent intent = new Intent(getActivity(), ChartActivity.class);
                Bundle bundle= new Bundle();
//                bundle.putSerializable("list",lr);
                bundle.putStringArrayList("title",title);
                bundle.putIntegerArrayList("score",score);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    return view;
    }
    void initData(){
        dbManager =new DBManager(getActivity().getApplicationContext());
        Cursor cursor=dbManager.queryScoreCursor(tablename);
        Score r = new Score();
 //       final List<String>tablename = new ArrayList<String>();
        while(cursor.moveToNext()) {
            r.setTitle(cursor.getString(cursor.getColumnIndex("title")));
//            r.setTablename(cursor.getString(cursor.getColumnIndex("tablename")));
            r.setScore(cursor.getInt(cursor.getColumnIndex("score")));
            lr.add(r);
            title.add(r.getTitle());
//            tablename.add(r.getTablename());
            score.add(r.getScore());
        }
    }
}
