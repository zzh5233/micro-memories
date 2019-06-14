package com.itzzh.springcloud.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
    private Long userId;	//编号 主键
    private String username;	//用户名
    private String password;	//密码
    private Date createTime;	//创建时间
    private String address;		//地址
    private String email;	//邮件
    private String phoneNumber;	//电话号码
    private String isVIP;	//是否VIP

    private Map<Date,Memory> memories = new HashMap<Date, Memory>(0);	//记忆

    public User() {
        super();
    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Date createTime) {
        super();
        this.username = username;
        this.password = password;
        this.createTime = createTime;
    }
    public User(Long userId, String username, String password, Date createTime, String address, String email,
                String phoneNumber, String isVIP, Map<Date, Memory> memories) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isVIP = isVIP;
        this.memories = memories;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getIsVIP() {
        return isVIP;
    }
    public void setIsVIP(String isVIP) {
        this.isVIP = isVIP;
    }
    public Map<Date, Memory> getMemories() {
        return memories;
    }
    public void setMemories(Map<Date, Memory> memories) {
        this.memories = memories;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isVIP='" + isVIP + '\'' +
                ", memories=" + memories +
                '}';
    }
}
