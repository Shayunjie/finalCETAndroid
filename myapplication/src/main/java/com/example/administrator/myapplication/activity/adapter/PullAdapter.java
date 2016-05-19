package com.example.administrator.myapplication.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.List;

/**
 * Created by 沙云杰 on 2016/5/5.
 */
public class PullAdapter extends RecyclerView.Adapter<PullAdapter.MyViewHolder>{
    private List<String> mlist;
    private Context mcontext;
    private OnClickItemListener ItemListener = null;

    public  interface OnClickItemListener{
        void OnClickListener(View view,int position);
    }
    public void setOnItemClickListener(OnClickItemListener listener){
        this.ItemListener = listener;

    }
    public PullAdapter(List<String> list,Context context){
        this.mlist = list;
        this.mcontext = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext)
                .inflate(R.layout.list,parent,false);
        MyViewHolder myViewHolder =new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.textView.setText(mlist.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos  = holder.getPosition();
                ItemListener.OnClickListener(view,pos);
            }
        });
            }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.tv_title);
        }
    }

}
