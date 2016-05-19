package com.example.administrator.myapplication.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.domain.LongReading;

import java.util.List;

/**
 * Created by 沙云杰 on 2016/4/22.
 */
public class TopicAdapter extends BaseAdapter {
   public  Context mcontext =null;
    public LayoutInflater mInflater;
    public List<LongReading> mlist;
    public TopicAdapter(Context context,List<LongReading> list){
        this.mcontext=context;
        mlist=list;
        mInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
    }
    final class ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
    }
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(null == convertView){
            holder = new ViewHolder();
            convertView =  mInflater.inflate(R.layout.topicadapter,null);
            holder.textView1 = (TextView)convertView.findViewById(R.id.tv_ad_tp);
//            holder.textView2 = (TextView)convertView.findViewById(R.id.tv_ad_sc);
//            holder.textView3 = (TextView)convertView.findViewById(R.id.tv_ad_tv);
            holder.textView1.setText(mlist.get(i).getTitle());
//            holder.textView2.setText(mlist.get(i).getScore());
            convertView.setTag(holder);
        }else{
            holder =(ViewHolder)convertView.getTag();
        }

        return convertView;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
