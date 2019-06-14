package com.zzh.springcloud.otherTest;

import com.sun.xml.internal.ws.api.model.CheckedException;

import java.util.HashSet;

public interface ExceptionDemo {
    public static void main(String[] args) {

        new RuntimeException();

        new Error();

        //new HashSet<>();


    }
}
