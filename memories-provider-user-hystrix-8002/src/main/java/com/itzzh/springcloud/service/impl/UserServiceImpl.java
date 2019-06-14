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
    public boolean addUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return dao.deleteUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public User getUserById(Long userId) {
        return dao.getUserById(userId);
    }

    @Override
    public List<User> getUserByName(String username) {
        return dao.getUserByName(username);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }
}
