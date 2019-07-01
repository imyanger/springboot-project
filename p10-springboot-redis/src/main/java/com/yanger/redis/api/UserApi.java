package com.yanger.redis.api;

import com.yanger.redis.po.User;
import com.yanger.redis.service.UserService;
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
        int id = userService.addUser(user);
        return "添加用户成功，主键id：" + id;
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
     * 获取用户信息，注解缓存
     * @param id
     * @return
     */
    @GetMapping("getUserAnno")
    public User getUserAnno(@RequestParam(value = "id") int id){
        return userService.getUserAnno(id);
    }

    @GetMapping("getUsers")
    public List<User> getUsers(){
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping("getUserByUP")
    public User getUserByUP(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        return userService.getUser(username, password);
    }

}
