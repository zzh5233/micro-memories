package com.itzzh.springcloud.service;

import com.itzzh.springcloud.entities.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/* hystrix服务降级，先暂时关闭服务*/
@Component//
public class UserClientServiceFallbackFactory implements FallbackFactory<UserClientService>{

    @Override
    public UserClientService create(Throwable cause) {
        return new UserClientService() {
            @Override
            public boolean addUser(User user) {
                return false;
            }

            @Override
            public boolean deleteUser(User user) {
                return false;
            }

            @Override
            public boolean updateUser(User user) {
                return false;
            }

            @Override
            public User getUserById(Long id) {
                User user = new User();
                user.setUserId(id);
                user.setUsername("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
                return user;
            }

            @Override
            public List<User> getUserByName(String username) {
                return null;
            }

            @Override
            public List<User> getAllUsers() {
                return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
