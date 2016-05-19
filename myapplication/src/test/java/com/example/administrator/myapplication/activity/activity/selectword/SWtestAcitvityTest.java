package com.example.administrator.myapplication.activity.activity.selectword;

import org.junit.Test;

/**
 * Created by 沙云杰 on 2016/5/6.
 */
public class SWtestAcitvityTest {
    int score;
    char a,b,c,d,e,f,g,h,i,j,k;


    @Test
    public void test(){
//        char[] a1 = new char[]{a,a,a,a,a,a,b};
//        char[] b1 = new char[]{a,b,c,d,e,f,g};
        String [] a1 =
                {"a","b","c","d"};
        String [] b1 = {"a","b","a","a"};
        int j = 0;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] == b1[i]) {
                score = ++j;
            }
        }
        System.out.println(score);
    }
}