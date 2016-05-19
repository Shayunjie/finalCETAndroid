package com.example.administrator.myapplication.activity.activity.Writing;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.db.DBManager;
import com.example.administrator.myapplication.activity.domain.Writting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 沙云杰 on 2016/4/19.
 */
public class zwActivity extends Activity {
    DBManager db;
    String tablename = "Writting";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = (ListView)findViewById(R.id.list_view);
         db =new DBManager(this);
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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.text ,title);
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
                                                intent.setClass(zwActivity.this,XiezuoActivity.class);
                                                startActivity(intent);
                                            }
                                        }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.closeDB();
    }
}
