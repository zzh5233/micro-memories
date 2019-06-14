package com.itzzh.springcloud.service;

import com.itzzh.springcloud.entities.User;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

    public boolean addUser(User user);

    public boolean deleteUser(User user);

    public boolean updateUser(User user);

    public User getUserById(Long userId);

    public List<User> getUserByName(String username);

    public List<User> getAllUsers();

}
