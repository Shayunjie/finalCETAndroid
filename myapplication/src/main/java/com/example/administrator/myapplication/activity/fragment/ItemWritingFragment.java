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
import com.example.administrator.myapplication.activity.activity.Writing.XiezuoActivity;
import com.example.administrator.myapplication.activity.db.DBManager;
import com.example.administrator.myapplication.activity.domain.Writting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 沙云杰 on 2016/4/19.
 */
public class ItemWritingFragment extends Fragment {
    DBManager db;
    String tablename = "Writting";

    //    Context mcontext = getActivity().getApplicationContext();
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
        Writting r = new Writting();
        List<String> title = new ArrayList<String>();
        final List<String>context = new ArrayList<String>();
        final List<String>input = new ArrayList<>();
        while(cursor.moveToNext()) {
            r.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            r.setContext(cursor.getString(cursor.getColumnIndex("context")));
            r.setInput(cursor.getString(cursor.getColumnIndex("input")));
            title.add(r.getTitle());
            context.add(r.getContext());
            input.add(r.getInput());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mcontext,R.layout.text ,title);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                Intent intent = new Intent();
                                                Bundle bundle = new Bundle();
                                                bundle.putString("context", context.get(i));
//                                                intent.putExtra("context",context.get(i));
//                                                intent.putExtra("id",i);
                                                bundle.putInt("id",i);
                                                bundle.putString("input", input.get(i));
                                                intent.putExtras(bundle);
                                                intent.setClass(mcontext,XiezuoActivity.class);
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
