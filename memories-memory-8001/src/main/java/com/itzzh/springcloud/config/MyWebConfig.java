package com.itzzh.springcloud.config;

import com.itzzh.springcloud.controller.converter.StringDateConverter;
import com.itzzh.springcloud.controller.converter.StringLongConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration  //放入容器中
public class MyWebConfig{

    /* SpringMVC的组件均可以在此设置*/
    @Bean
    public WebMvcConfigurerAdapter getWebMvcConfigurerAdapter(){
        return new WebMvcConfigurerAdapter() {

            /**
             * 添加视图映射
             * @param registry
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("memories");
//                registry.addViewController("/index.html").setViewName("memories");
            }

            /**
             * 添加格式转换器
             * @param registry
             */
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new StringDateConverter());
                registry.addConverter(new StringLongConverter());
            }

            /**
             * 添加资源路径映射
             * @param registry
             */
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/pic/**").addResourceLocations("file:E:/Codes/img/upload/");
            }

        };
    }

}
