package com.itzzh.springcloud.dao;

import com.itzzh.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.Valid;
import java.util.List;

@Mapper
public interface UserDao {

    public void addUser(User user);

    public User queryUserById(Long userId);

    public List<User> getUserByName(String username);

    public List<User> queryUsers();

    public void updateUser(@Valid User user);

    public void deleteUser(User user);

    public User getByUsernameAndPwd(User user);

}
