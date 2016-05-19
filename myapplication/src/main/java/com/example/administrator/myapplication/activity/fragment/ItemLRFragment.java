package com.example.administrator.myapplication.activity.fragment;

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
import com.example.administrator.myapplication.activity.activity.LongRead.NewLongRead;
import com.example.administrator.myapplication.activity.db.DBManager;
import com.example.administrator.myapplication.activity.domain.LongReading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 沙云杰 on 2016/4/22.
 */
public class ItemLRFragment extends Fragment{
    DBManager db;
    String tablename = "long";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sreading,container,false);
        initView(view);
        return view;
    }

    void initView(View view) {
        ListView listView =(ListView)view.findViewById(R.id.ls_reading);
        db =new DBManager(getActivity().getApplicationContext());
        Cursor cursor=db.queryTheCursor(tablename);
        LongReading r = new LongReading();
        List<LongReading>lr = new ArrayList<>();
        final List<String> title = new ArrayList<String>();
        final List<String>context = new ArrayList<String>();
        final List<String>answer = new ArrayList<>();
        final List<String>options = new ArrayList<>();
        while(cursor.moveToNext()) {
            r.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            r.setContext(cursor.getString(cursor.getColumnIndex("context")));
            r.setAnswer(cursor.getString(cursor.getColumnIndex("answer")));
            r.setOptions(cursor.getString(cursor.getColumnIndex("options")));
            lr.add(r);
            title.add(r.getTitle());
            context.add(r.getContext());
            answer.add(r.getAnswer());
            options.add(r.getOptions());
        }
 //       TopicAdapter adapter = new TopicAdapter(getActivity(),lr);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.text ,title);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                Intent intent = new Intent();
                                                Bundle bundle = new Bundle();
                                                bundle.putString("title",title.get(i));

                                                bundle.putString("context", context.get(i));
                                                bundle.putInt("id", i);
                                                bundle.putString("options",options.get(i));
                                                bundle.putString("answer", answer.get(i));
                                                intent.putExtras(bundle);
                                                intent.setClass(getActivity().getApplicationContext(),NewLongRead.class);
                                                startActivity(intent);
                                            }
                                        }
        );
    }
}
