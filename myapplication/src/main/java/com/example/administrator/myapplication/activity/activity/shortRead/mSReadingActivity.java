package com.example.administrator.myapplication.activity.activity.shortRead;

/**
 * Created by 沙云杰 on 2016/4/20.
 */
//public class mSReadingActivity extends Activity implements ReadingAdapter.CallBack{
//    public String title;
//    public String context;
//    public String answer;
//    public String options;
//    List<SRAnswer> list = new ArrayList<>();
//    TextView tv ;
//    Button bt ;
//    String result = null;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_msreading);
////          initList();
////        initIntent();
////        ListView listView = (ListView) findViewById(R.id.ls_sreading);
////        ReadingAdapter readingAdapter = new ReadingAdapter(list, this,this);
////        listView.setAdapter(readingAdapter);
////        tv = (TextView) findViewById(R.id.tv_msr);
////        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
////        tv.setText(context);
//
////        System.out.println();
//    }
//    public void save(int i ,SRAnswer srAnswer){
//        //// TODO: 2016/5/5
//        /*should have a button to subumit the answer
//        in the onClick():
//        StringBuilder sb = new StringBuilder();
//        sb.apped(srAnswer.getChoose());
//         */
//        System.out.println("------这里是mSReading-----------------第"+(i+1)+"题的答案是："+srAnswer.getChoose());
//    }
//    //        bt=(Button)findViewById(R.id.bt_msr);
////        bt.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                List<SRAnswer> list = new ArrayList<>();
//void initList() {
////        final SRAnswer answera = new SRAnswer();
////        answera.setAnswer(answer1);
////        SRAnswer answerb = new SRAnswer();
////        answerb.setAnswer(answer2);
////        SRAnswer answerc = new SRAnswer();
////        answerc.setAnswer(answer3);
////        SRAnswer answerd = new SRAnswer();
////        answerd.setAnswer(answer4);
////        SRAnswer answere = new SRAnswer();
////        answere.setAnswer(answer5);
////        list.add(answera);
////        list.add(answerb);
////        list.add(answerc);
////        list.add(answerd);
////        list.add(answere);
//    }
//
//    void initIntent(){
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        answer=bundle.getString("answer");
//        options=bundle.getString("options");
//        title =bundle.getString("title");
//        context=bundle.getString("context");
//
//    }
//
//}
