package com.zzh.springcloud.otherTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDemo {
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>();
        list1.add("aa");


        List<Object> list0 = new ArrayList<Object>();

        //list0 = list1; //编译报错

        List<? extends Object> listAll = new ArrayList<Object>();

        listAll = list1;
        System.out.println(listAll);

        //Map<String,String>[] maps = new HashMap<String,String>()[10];编译报错
//        Map<String,String>[] maps =(HashMap<String,String>[]) new HashMap[10];
//        maps[0].put("aaa","aaa");
//        System.out.println(maps[0].get("aaa"));//NullPointerException

        


    }
}
