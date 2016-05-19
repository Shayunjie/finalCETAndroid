package com.example.administrator.myapplication.activity.activity.shortRead;

/**
 * Created by 沙云杰 on 2016/4/21.
 */
//public class SRanswerActivity extends Activity implements ReadingAdapter.CallBack{
//    List<SRAnswer> list = new ArrayList<>();
//    int incorrectAnswer=0;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_listanswer);
//        list = (List<SRAnswer>) getIntent().getSerializableExtra("answer");
////        SRAnswer answer =(SRAnswer)intent.getSerializableExtra("answer");
//  //      String [] answer =intent.getStringArrayExtra("test" );
//        ListView listView = (ListView)findViewById(R.id.ls_sreading);
////        for(int i = 0;i<answer.length;i++){
////            list.add(i);
//////            list.add(answer[i]);
////        }
//        ReadingAdapter ra= new ReadingAdapter(list,this,this);
//        listView.setAdapter(ra);
//        for(int i=0;i<list.size();i++){
//            if(list.get(i).getAnswer().equalsIgnoreCase(list.get(i).getChoose())){
//                incorrectAnswer++;
//            }else{
//                System.out.println("第"+(i+1)+"题错误，正确答案应该是："+list.get(i).getAnswer());
//            }
//        }
//    }
//public void save(int di,SRAnswer srAnswer){
//    System.out.println("---------------this is SranswerActivity?????");
//}
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("-------------","dialog has been destory!!!!!");
//    }
//}
