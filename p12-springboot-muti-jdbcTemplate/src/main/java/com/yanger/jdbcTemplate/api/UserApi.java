package com.yanger.jdbcTemplate.api;

import com.yanger.jdbcTemplate.service.UserService;
import com.yanger.jdbcTemplate.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserApi {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param user
     */
    @PostMapping("addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "添加用户成功";
    }

    /**
     * 添加用户
     * @param user
     */
    @PostMapping("addUserSlave")
    public String addUserSlave(User user){
        userService.addUserSlave(user);
        return "添加用户成功";
    }

    /**
     * 删除用户
     * @param id
     */
    @GetMapping("delUser")
    public String delUser(@RequestParam(value = "id") int id){
        userService.delUser(id);
        return "删除用户成功";
    }

    /**
     * 修改用户信息
     * @param user
     */
    @PostMapping("updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "修改用户成功";
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @GetMapping("getUser")
    public User getUser(@RequestParam(value = "id") int id){
        return userService.getUser(id);
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @GetMapping("getUsers")
    public List<User> getUsers(){
        List<User> users = userService.findAll();
        return users;
    }

    /**
     * slave获取所有用户信息
     * @return
     */
    @GetMapping("getUsersBySlave")
    public List<User> getUsersBySlave(){
        List<User> users = userService.findAllSlave();
        return users;
    }

}
