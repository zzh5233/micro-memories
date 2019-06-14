package com.itzzh.springcloud.controller.converter;

import org.springframework.core.convert.converter.Converter;

/* 实现将输入的字符串转换成长整型*/
public class StringLongConverter implements Converter<String,Long>{

    @Override
    public Long convert(String source) {
        try {
            //转换成功后返回
            return Long.parseLong(source);
        }catch (Exception e){
            e.printStackTrace();
        }
        //转换失败
        return null;
    }
}
