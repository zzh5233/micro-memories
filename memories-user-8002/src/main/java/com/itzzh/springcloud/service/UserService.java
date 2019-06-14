package com.itzzh.springcloud.service;

import com.itzzh.springcloud.entities.User;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

    public void addUser(User user);

    public User queryUserById(Long userId);

    public List<User> getUserByName(String username);

    public List<User> queryUsers();

    public void updateUser(Long userId, @Valid User user);

    public void deleteUser(User user);

    public User login(String username, String password);
}
