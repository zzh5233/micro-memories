package com.itzzh.springcloud.cfgbeans;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.MultipartConfigElement;

@Configuration
public class FileUploadConfig {

//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
//        // 这样在文件上传的地方就需要进行异常信息的处理了;
////        factory.setMaxFileSize("256KB"); // KB,MB
////        /// 设置总上传数据总大小
////        factory.setMaxRequestSize("512KB");
//        // Sets the directory location where files will be stored.
//        factory.setLocation("E:/Codes/img/upload/");
//        return factory.createMultipartConfig();
//    }

    @Bean
    public MultipartResolver multipartResolver(){

        CommonsMultipartResolver resolver = new CommonsMultipartResolver();

        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(5*1024*1024);
        return resolver;
    }


}
