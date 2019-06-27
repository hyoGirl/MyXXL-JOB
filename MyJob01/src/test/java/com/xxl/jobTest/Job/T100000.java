package com.xxl.jobTest.Job;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: xulei
 * @Date: 2019/6/26 0026 15:15
 * @Description:
 */
public class T100000 {


    public static void main(String[] args) {

//        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        List<String> list=new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            String ss="ASDFG"+"-"+i;
            list.add(ss);
        }
        System.out.println(JSON.toJSON(list));
        list=null;


    }



}
