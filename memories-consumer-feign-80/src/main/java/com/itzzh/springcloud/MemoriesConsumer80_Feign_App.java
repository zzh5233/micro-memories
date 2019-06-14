package com.itzzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient //eureka的客户端
@EnableFeignClients(basePackages = {"com.itzzh.springcloud"})
@ComponentScan("com.itzzh.springcloud")
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class MemoriesConsumer80_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(MemoriesConsumer80_Feign_App.class,args);
    }
}
