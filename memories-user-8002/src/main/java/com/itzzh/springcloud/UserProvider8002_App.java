package com.itzzh.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 独立的应用，不进行注册，便于调试*/
@SpringBootApplication
public class UserProvider8002_App {

    public static void main(String[] args) {
        SpringApplication.run(UserProvider8002_App.class,args);
    }
}
