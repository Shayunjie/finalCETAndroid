package com.example.administrator.myapplication.activity.activity.shortRead;

;

/**
 * Created by 沙云杰 on 2016/5/5.
 */
//public class ShortSelectFragment extends Fragment {
//    EditText editText;
//    TextView textView;
//    TextView tv;
//    FloatingActionButton button;
//    String options;
//    String answer;
//    int score;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fra_selest,container,false);
//        textView=(TextView)view.findViewById(R.id.tv_fra_select);
//        editText=(EditText)view.findViewById(R.id.et_fra_select);
//        tv = (TextView)view.findViewById(R.id.tv_fra_answer);
//        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
//        tv.setText("");
//        button=(FloatingActionButton)view.findViewById(R.id.fab_act_select);
//        if(getArguments()!=null) {
//            Bundle bundle = getArguments();
//            options = bundle.getString("options");
//            answer = bundle.getString("answer");
//            textView.setText(options);
//        }
//        if(answer.length()==5){
//            InputFilter[] filters = {new InputFilter.LengthFilter(5)};
//            editText.setFilters(filters);
//        }else {
//            InputFilter[] filters = {new InputFilter.LengthFilter(5)};
//            editText.setFilters(filters);
//        }
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String choose = editText.getText().toString();
//                //               List<Integer> list = new ArrayList<Integer>();
//                char[] a1 = choose.toCharArray();
//                char[] b1 = answer.toCharArray();
//                if (a1.length < 5) {
//                    Toast.makeText(getActivity(), "输入答案少于题数，请核对后确认", Toast.LENGTH_LONG).show();
//                } else {
//
//                    int j = 0;
//                    for (int i = 0; i < a1.length; i++) {
//                        if (a1[i] == b1[i]) {
//                            score = ++j;
//                        }
//                    }
//                    tv.setText("您的得分为：" + score+ "请再接再厉！\n" +
//                            "正确答案是：" + answer);
//
//                }
//            }
//        });
//        return view;
//    }
//}
