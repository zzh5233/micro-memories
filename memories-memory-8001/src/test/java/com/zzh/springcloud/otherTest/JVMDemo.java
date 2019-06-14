package com.zzh.springcloud.otherTest;

import java.util.ArrayList;
import java.util.List;

public class JVMDemo {

    static class OOMObject{
    }
    /**
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PermSize=32M         -XX:MaxPermSize=64M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) throws ClassNotFoundException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        int count = 0;
        while(true){
            list.add(new OOMObject());
            System.out.println("共构造了"+ (count++) +"个对象");

            Class.forName("com.mysql.jdbc.Driver");
        }
    }

}
