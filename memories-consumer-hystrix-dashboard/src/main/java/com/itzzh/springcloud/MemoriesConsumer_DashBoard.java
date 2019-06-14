package com.itzzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard  //开启实时监控
public class MemoriesConsumer_DashBoard {
    public static void main(String[] args) {
        SpringApplication.run(MemoriesConsumer_DashBoard.class,args);
    }
}
