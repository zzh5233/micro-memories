package com.itzzh.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //服务启动后自动注册进eureka服务器中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //对hystrixR熔断机制的支持
public class UserProvider8002_Hystrix_App {

    public static void main(String[] args) {
        SpringApplication.run(UserProvider8002_Hystrix_App.class,args);
    }
}
