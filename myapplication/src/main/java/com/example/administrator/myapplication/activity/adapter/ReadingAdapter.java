package com.example.administrator.myapplication.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.domain.SRAnswer;

import java.util.List;

/**
 * Created by 沙云杰 on 2016/4/21.
 */
public class ReadingAdapter extends BaseAdapter  {
    private Context mcontext = null;
    private LayoutInflater mInflater;
    public List<SRAnswer> m ;
    public interface CallBack{
        public void save(int id,SRAnswer result);
    }
    public CallBack mcallBack;

    public ReadingAdapter(List<SRAnswer>list , Context context,CallBack callBack){
        this.mcontext=context;
        this.m= list;
        this.mcallBack=callBack;
        mInflater=LayoutInflater.from(mcontext);
    }

    @Override
    public int getCount() {
        return m.size();
    }

    @Override
    public SRAnswer getItem(int i) {
        return m.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    final class ViewHolder {
        RadioGroup radioGroup;
        TextView textView;
        RadioButton radioButtona;
        RadioButton radioButtonb;
        RadioButton radioButtonc;
        RadioButton radioButtond;
    }
    @Override
    public View getView(final int i, View convertview, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
      final SRAnswer srAnswer = m.get(i);

      //      ShortReading sr = m.get(i);
        if(convertview==null){
            viewHolder=new ViewHolder();
            convertview=mInflater.inflate(R.layout.activity_sranswer,null);
            viewHolder.radioGroup=(RadioGroup)convertview.findViewById(R.id.rg_reading);
            viewHolder.radioButtona=(RadioButton)convertview.findViewById(R.id.rb_a);
            viewHolder.radioButtonb=(RadioButton)convertview.findViewById(R.id.rb_b);
            viewHolder.radioButtonc=(RadioButton)convertview.findViewById(R.id.rb_c);
            viewHolder.radioButtond=(RadioButton)convertview.findViewById(R.id.rb_d);
            viewHolder.textView=(TextView)convertview.findViewById(R.id.tv_ls_sr);
            viewHolder.textView.setText("第"+(i+1)+"题");
            convertview.setTag(viewHolder);
            viewHolder.radioGroup.setOnCheckedChangeListener(
                    new RadioGroup.OnCheckedChangeListener() {
                String result = null;
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int id) {
                    if (id == viewHolder.radioButtona.getId())
                        result = "A";
                    if (id == viewHolder.radioButtonb.getId())
                        result = "B";
                    if (id == viewHolder.radioButtonc.getId())
                        result = "C";
                    if (id == viewHolder.radioButtond.getId()){
                        result = "D";}
                       srAnswer.setChoose(result);
                    mcallBack.save(i,srAnswer);
//   //             submit(srAnswer);
//     //           System.out.println("-----------------------第"+(i+1)+"题的答案是："+srAnswer.getChoose());
     }
           });


        }else{
            viewHolder=(ViewHolder)convertview.getTag();
        }

        return convertview;
    }
    //   void submit(SRAnswer srAnswer){

  //  }
}
