package com.itzzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;

/* 独立的应用，不进行注册，便于调试*/
@SpringBootApplication
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class Memory8001_App {
    public static void main(String[] args) {
        SpringApplication.run(Memory8001_App.class,args);
    }
}
