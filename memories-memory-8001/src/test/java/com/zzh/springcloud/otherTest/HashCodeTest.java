package com.zzh.springcloud.otherTest;

import java.util.HashMap;
import java.util.Map;

public class HashCodeTest {
    public static void main(String[] args) {
//        Person p1 = new Person();
//        Person p2 = new Person();
//
//        System.out.println("p1:-->"+p1);
//        System.out.println("p2:-->"+p2);
//        System.out.println("p1.hashCode:-->"+p1.hashCode());
//        System.out.println("p2.hashCode:-->"+p2.hashCode());
//        System.out.println("p1.equals(p2):-->"+p1.equals(p2));
//        System.out.println("p2.equals(p1):-->"+p2.equals(p1));

        String str1 = "hello";
        String str2 = "hello";
//        System.out.println(str1);
//        System.out.println(str1.toString());
//
//        System.out.println("str1.hashCode:-->"+str1.hashCode());
//        System.out.println("str2.hashCode:-->"+str2.hashCode());
        System.out.println("str1.equals(str2):-->"+str1.equals(str2));
        System.out.println("str2.equals(str1):-->"+str2.equals(str1));
//        System.out.println("str2==str2:-->"+str1==str2);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("aa","aaa");


    }
}
