package com.itzzh.springcloud.entities;

import java.io.Serializable;
import java.util.Date;

public class Memory implements Serializable {
    private Long memoryId;		//记忆编号
    private String picture;		//图片地址
    private String description;	//描述
    private Date moment;	//产生时刻
    private String mood;	//心情
    private String weather;	//天气
    private String location;	//位置

    public Long getMemoryId() {
        return memoryId;
    }
    public void setMemoryId(Long memoryId) {
        this.memoryId = memoryId;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getMood() {
        return mood;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }
    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public Date getMoment() {
        return moment;
    }
    public void setMoment(Date moment) {
        this.moment = moment;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "memoryId=" + memoryId +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                ", moment=" + moment +
                ", mood='" + mood + '\'' +
                ", weather='" + weather + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
