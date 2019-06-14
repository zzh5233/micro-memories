package com.itzzh.springcloud.dao;

import com.itzzh.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.Valid;
import java.util.List;

@Mapper
public interface UserDao {

    public boolean addUser(User user);

    public boolean deleteUser(User user);

    public boolean updateUser(User user);

    public User getUserById(Long userId);

    public List<User> getUserByName(String username);

    public List<User> getAllUsers();

//    public User getByUsernameAndPwd(User user);

}
