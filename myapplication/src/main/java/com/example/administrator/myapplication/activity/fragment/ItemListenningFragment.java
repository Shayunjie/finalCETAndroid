package com.example.administrator.myapplication.activity.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.activity.LongRead.ListenningActivity;
import com.example.administrator.myapplication.activity.db.DBManager;
import com.example.administrator.myapplication.activity.domain.Listenning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 沙云杰 on 2016/4/19.
 */
public class ItemListenningFragment extends Fragment {
    DBManager db;
    String tablename = "listenning";
    Context mcontext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mcontext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list,container,false);
        initView(view);
        return view;
    }

   void initView(View view) {
        ListView listView = (ListView)view.findViewById(R.id.list_view);
         db =new DBManager(mcontext);
        Cursor cursor=db.queryTheCursor(tablename);
       Listenning r = new Listenning();
        List<String> title = new ArrayList<String>();
       final List<String>word = new ArrayList<>();
        final List<String>url = new ArrayList<String>();
        final List<String>options = new ArrayList<>();
        final List<String>answer = new ArrayList<>();
        while(cursor.moveToNext()) {
            r.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            r.setUrl(cursor.getString(cursor.getColumnIndex("url")));
            r.setOptions(cursor.getString(cursor.getColumnIndex("options")));
            r.setAnswer(cursor.getString(cursor.getColumnIndex("answer")));
            r.setWord(cursor.getString(cursor.getColumnIndex("word")));
            title.add(r.getTitle());
            url.add(r.getUrl());
            options.add(r.getOptions());
            answer.add(r.getAnswer());
            word.add(r.getWord());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mcontext,R.layout.text ,title);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                Intent intent = new Intent();
                                                Bundle bundle = new Bundle();
                                                bundle.putString("context", url.get(i));
                                                bundle.putString("options",options.get(i));
                                                bundle.putInt("id",i);
                                                bundle.putString("answer", answer.get(i));
                                                bundle.putString("word",word.get(i));
                                                intent.putExtras(bundle);
                                                intent.setClass(mcontext,ListenningActivity.class);
                                                startActivity(intent);
                                            }
                                        }
        );
    }

    @Override
    public void onDestroy() {
        db.closeDB();
        super.onDestroy();
    }
}
