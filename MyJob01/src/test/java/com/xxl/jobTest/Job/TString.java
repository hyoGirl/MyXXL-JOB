package com.xxl.jobTest.Job;

/**
 * @Auther: xulei
 * @Date: 2019/6/26 0026 16:51
 * @Description:
 */
public class TString {

    public static void main(String[] args) throws  Exception{

        StringBuilder stringBuilder=new StringBuilder();



        for (int i = 1; i <=10000 ; i++) {
            String ss="ASDFG"+"-"+i;
            stringBuilder.append(ss);
        }


        System.out.println(stringBuilder.toString().getBytes("UTF-8").length);

    }
}
