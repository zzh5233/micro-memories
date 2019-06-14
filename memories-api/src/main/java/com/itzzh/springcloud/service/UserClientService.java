package com.itzzh.springcloud.service;

import com.itzzh.springcloud.entities.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MEMORIES-USER",fallbackFactory = UserClientServiceFallbackFactory.class)
public interface UserClientService {

    /* 添加*/
    @RequestMapping(value = "/user/add",method= RequestMethod.POST )
    public boolean addUser(@RequestBody User user);
    /* 删除*/
    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    public boolean deleteUser(@RequestBody User user);

    /* 修改*/
    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public boolean updateUser(@RequestBody User user);

    /* 查询单个*/
    @RequestMapping(value = "/user/get/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id);

    /* 查询通过名字*/
    @RequestMapping(value = "/user/{username}",method = RequestMethod.GET)
    public List<User> getUserByName(@PathVariable("username") String username);

    /* 查询全部*/
    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public List<User> getAllUsers();

    /* 服务发现*/
    @RequestMapping(value="/user/discovery", method = RequestMethod.GET)
    public Object discovery();


}
