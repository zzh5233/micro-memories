package com.itzzh.springcloud.controller;

import com.itzzh.springcloud.entities.User;
import com.itzzh.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private DiscoveryClient client;

    /* 添加*/
    @RequestMapping(value = "/user/add",method= RequestMethod.POST )
    public boolean addUser(@RequestBody User user){
        return service.addUser(user);
    }

    /* 删除*/
    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    public boolean deleteUser(@RequestBody User user){
        return service.deleteUser(user);
    }

    /* 修改*/
    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public boolean updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    /* 查询单个*/
    @HystrixCommand(fallbackMethod="processHystrix_Get") //hystrix熔断
    @RequestMapping(value = "/user/get/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id){
        User user = service.getUserById(id);
        if(null == user)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return user;
    }
    public User processHystrix_Get(@PathVariable("id") Long id) //熔断处理，返回一个自定义的对象
    {
        User user = new User();
        user.setUserId(id);
        user.setUsername("该ID："+id+"没有没有对应的信息,null--@HystrixCommand");
        return user;
    }

    /* 查询通过名字*/
    @RequestMapping(value = "/user/{username}",method = RequestMethod.GET)
    public List<User> getUserByName(@PathVariable("username") String username){
        return service.getUserByName(username);
    }

    /* 查询全部*/
    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    /* 服务发现*/
    @RequestMapping(value="/user/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MEMORIES-USER");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
