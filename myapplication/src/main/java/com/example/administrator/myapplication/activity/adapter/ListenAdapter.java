package com.example.administrator.myapplication.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.administrator.myapplication.R;

/**
 * Created by 沙云杰 on 2016/5/10.
 */
public class ListenAdapter extends BaseAdapter {
    private String[] mlisten;
    private Context mcontext;
    LayoutInflater inflater;
    public ListenAdapter(Context context,String[] listen){
        this.mcontext = context;
        inflater = LayoutInflater.from(mcontext);
        this.mlisten = listen;
    }
    @Override
    public int getCount() {
        return mlisten.length;
    }

    @Override
    public Object getItem(int i) {
        return mlisten[i];
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if(view==null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.edite, null);
            viewHolder.et = (EditText)view.findViewById(R.id.et);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        return view;
    }
    final class ViewHolder{
        EditText et;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
