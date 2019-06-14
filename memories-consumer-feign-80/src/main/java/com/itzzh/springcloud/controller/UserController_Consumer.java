package com.itzzh.springcloud.controller;

import com.itzzh.springcloud.entities.User;
import com.itzzh.springcloud.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController_Consumer {

    @Autowired
    private UserClientService service;

    @RequestMapping("/get/{id}")
    public String getUserById(@PathVariable("id") Long userId, Map<String,Object> map) {
        User user = service.getUserById(userId);
        map.put("user",user);
        return "success";
    }

    @RequestMapping("/getUserById")
    public String queryUserById(Long userId,Map<String,Object> map) {
        User user = service.getUserById(userId);

        //把时间换算为当地时间
        String createTime = user.getCreateTime().toLocaleString();
        map.put("createTime",createTime);

        map.put("user",user);
        return "user/userDetail";
    }

    @RequestMapping("/getUserByName")
    public String getUserByName(Model model) {
        List<User> userList = service.getUserByName("zz");
        model.addAttribute("userList",userList);
        return "success";
    }

    @RequestMapping("/queryUsers")
    public String queryUsers(Map<String,Object> map) {
        List<User> userList = service.getAllUsers();
        map.put("userList",userList);
        return "user/userList";
    }

    @RequestMapping("/addUserUI")
    public String addUserUI(Map<String,Object> map) {
//		//准备当前的时间
//		String createTime = new Date().toLocaleString();
//		map.put("createTime",createTime);
        return "user/addUserUI";
    }

    @RequestMapping("/addUser")
    public String addUser(User user) {
        //添加用户
        service.addUser(user);
        return "redirect:queryUsers";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Long userId) {
        //根据id查询到相应的记忆，再做修改
        User user = service.getUserById(userId);
        //删除用户
        service.deleteUser(user);
        return "redirect:queryUsers";
    }

    @RequestMapping("/editUserUI")
    public String editUserUI(Long userId,Map<String,Object> map) throws Exception {
        //现根据id，查询到对应的用户
        User user = service.getUserById(userId);
        if(user == null) {
//            throw new CustomException("没有查询到此用户信息");
            throw new RuntimeException("先以此代替");
        }
        //把时间换算为当地时间
        if( user.getCreateTime() != null) {
            String createTime = user.getCreateTime().toLocaleString();
            map.put("createTime",createTime);
        }
        //回显其余的用户信息
        map.put("user",user);
        return "user/editUserUI";
    }

    @RequestMapping("/editUser")
    public String editUser(Model model,
                           Long userId,
                           @Valid User user,
                           BindingResult bindingResult) {

        //获取校验的错误信息
        if(bindingResult.hasErrors()) {
            //取出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for(ObjectError objectError:allErrors) {
                //输出错误信息
                System.out.println(objectError.getDefaultMessage());
            }
            //将错误信息传到页面
            model.addAttribute("allErrors",allErrors);
            //跳会到修改页面进行错误显示
            return "user/editUserUI";
        }

        //调用service完成更新商品信息，页面需要将商品的信息传到此方法上
        user.setUserId(userId);
        service.updateUser(user);
        return "redirect:queryUsers";
    }
}
