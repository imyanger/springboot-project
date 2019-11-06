package com.yanger.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanger
 * @description 服务方
 * @date 2019/11/6
 */
@Slf4j
@RestController
@RequestMapping("server")
public class ServerApi {

    private User user = new User("晓明", 18);

    @GetMapping("user")
    public User getUser() {
        log.info("获取用户信息{}", user);
        return user;
    }

    @GetMapping("guser")
    public User getUserByName(@RequestParam String name) {
        log.info("根据参数中用户名{}获取用户信息", name);
        if(name.equals(user.getName())){
            return user;
        }
        return new User();
    }
    @GetMapping("guser/{name}")
    public User getUserByPathName(@PathVariable String name) {
        log.info("根据path中用户名{}获取用户信息", name);
        if(name.equals(user.getName())){
            return user;
        }
        return new User();
    }

    @PostMapping("user")
    public String setUser(@RequestBody User user) {
        this.user.setName(user.getName());
        this.user.setAge(user.getAge());
        log.info("修改用户信息{}", user);
        return "Ok";
    }

}
