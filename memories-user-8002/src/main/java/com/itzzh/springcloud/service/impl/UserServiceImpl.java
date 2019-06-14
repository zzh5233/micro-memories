package com.itzzh.springcloud.service.impl;

import com.itzzh.springcloud.dao.UserDao;
import com.itzzh.springcloud.entities.User;
import com.itzzh.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User queryUserById(Long userId) {
        return dao.queryUserById(userId);
    }

    @Override
    public List<User> getUserByName(String username) {
        return dao.getUserByName(username);
    }

    @Override
    public void addUser(User user) {
        //TODO 密码用MD5进行加密
        String oldPassword = user.getPassword();

        //调用mapper保存到数据库中
        dao.addUser(user);
    }

    @Override
    public List<User> queryUsers() {
        return dao.queryUsers();
    }

    @Override
    public void updateUser(Long userId, @Valid User user) {
        //添加业务校验，通常在service接口对关键参数进行校验
        //检验id是否为空，若为空抛出异常

        user.setUserId(userId);
        dao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    @Override
    public User login(String username, String password) {
        //封装成一个user对象，因为Mybatis的访问数据库只接受一个参数
        User user = new User(username, password);
        return dao.getByUsernameAndPwd(user);
    }

}
