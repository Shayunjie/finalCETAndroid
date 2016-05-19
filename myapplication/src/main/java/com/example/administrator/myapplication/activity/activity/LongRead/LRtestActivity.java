package com.example.administrator.myapplication.activity.activity.LongRead;

/**
 * Created by 沙云杰 on 2016/4/22.
 */
//public class LRtestActivity extends Activity {
//    public String context;
//    public String answer;
//    public int score ;
//    TextView textView;
//    EditText editText;
//    Button button;
//    TextView tv;
//    DBManager dbManager;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_answer_edit);
//        initIntent();
//        //// TODO: 2016/5/6
//        Bundle bundletest = new Bundle();
//        TestFragment testFragment = new TestFragment();
//        testFragment.setArguments(bundletest);
//        Bundle bundleSelect =new Bundle();
//        SelectFragment selectFragment = new SelectFragment();
//        selectFragment.setArguments(bundleSelect);
//        //
//        editText = (EditText)findViewById(R.id.et_answer_edit);
//        textView = (TextView)findViewById(R.id.tv_answer_edit);
//        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
//        textView.setText(context);
//        tv = (TextView)findViewById(R.id.tv_lr_test);
//        tv.setText("");
//        button = (Button)findViewById(R.id.btn_lr_test);
// //       System.out.println("-------------------"+score);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String choose = editText.getText().toString();
//                //               List<Integer> list = new ArrayList<Integer>();
//                char[] a1 = choose.toCharArray();
//                char[] b1 = answer.toCharArray();
//                if (a1.length < 10) {
//                    Toast.makeText(getApplicationContext(), "输入答案少于题数，请核对后确认", Toast.LENGTH_LONG).show();
//                } else {
//
//                    for ( int i = 0,j = 0; i < 9; i++) {
//                        if (a1[i] == b1[i]) {
//                            j++;
//                            score = j;
//                            break;
//                        }
//                    }
//                    tv.setText("您的得分为：" + score+ "请再接再厉！\n" +
//                            "正确答案是：" + answer);
//
//            }
//        }
//    });
//        saveScore();
//    }
//    void initIntent(){
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        context = bundle.getString("context");
//        answer = bundle.getString("answer");
// //       Log.v("-------------------",answer);
////        score = bundle.getInt("score");
//    }
//    void saveScore(){
////        input = editText.getText().toString();
////        dbManager.update("longReading", input, i);
//    }
//}
