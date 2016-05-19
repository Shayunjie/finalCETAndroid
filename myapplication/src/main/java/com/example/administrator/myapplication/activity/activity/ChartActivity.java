package com.example.administrator.myapplication.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 沙云杰 on 2016/5/5.
 */
public class ChartActivity extends Activity {
    private Random random;//用于产生随机数

    private BarChart chart;
    private BarData data;
    private BarDataSet dataSet;
 //   List<Integer> score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        ArrayList<String>title = intent.getStringArrayListExtra("title");
        ArrayList<Integer>score = intent.getIntegerArrayListExtra("score");

        //    setContentView(R.layout.chart);
        //设置显示图表
        chart = new BarChart(getApplicationContext());
        setContentView(chart);
//        score = new ArrayList<Integer>();
//        for(int j = 0; j<12;j++){
//            score.add(j);
//        }

        /**图表具体设置*/
        ArrayList<BarEntry> entries = new ArrayList<>();//显示条目
        ArrayList<String> xVals = new ArrayList<String>();//横坐标标签
        for(int i=0;i<score.size();i++){
            entries.add(new BarEntry(score.get(i),i));
        }
//        random=new Random();//随机数
//        for(int i=0;i<12;i++){
//            float profit= random.nextFloat();
//            //entries.add(BarEntry(float val,int positon);
//            entries.add(new BarEntry(score.get(i),i));
//            xVals.add("第"+(i+1)+"次");
//        }
        dataSet = new BarDataSet(entries, "成绩表");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data = new BarData(title, dataSet);
        chart.setData(data);
        //设置Y方向上动画animateY(int time);
        chart.animateY(3000);
        //图表描述
        chart.setDescription("您最近答题的得分情况");

    }
}
