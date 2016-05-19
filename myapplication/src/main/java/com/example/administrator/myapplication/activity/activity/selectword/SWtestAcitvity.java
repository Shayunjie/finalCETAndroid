package com.example.administrator.myapplication.activity.activity.selectword;

/**
 * Created by 沙云杰 on 2016/4/22.
 */
//public class SWtestAcitvity extends Activity {
//    public String context;
//    public String answer;
//    public String options;
//    TextView textView;
//    EditText editText;
//    TextView tv;
//    Button button;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_answer_edit);
//        initIntent();
//        editText= (EditText)findViewById(R.id.et_answer_edit);
//        textView = (TextView)findViewById(R.id.tv_answer_edit);
//        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
//        textView.setText(context);
//        tv = (TextView)findViewById(R.id.tv_lr_test);
//        tv.setText("");
//        button = (Button)findViewById(R.id.btn_lr_test);
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
//                    int j = 0;
//                    for (int i = 0; i < a1.length; i++) {
//                        if (a1[i] == b1[i]) {
//                             ++j;
//                        }
//                        tv.setText("您的得分为：" + j + "请再接再厉！\n" +
//                                "正确答案是：" + answer);
//                    }
//                }
//            }
//        });
//    }
//    void initIntent(){
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        context = bundle.getString("context");
//        answer = bundle.getString("answer");
//        options = bundle.getString("options");
//    }
//}
