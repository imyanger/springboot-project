package com.yanger.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanger
 * @description
 * @date 2019/11/6
 */
@Slf4j
@RestController
@RequestMapping("client")
public class ClientApi {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("user")
    public User getUser() {
        User user = restTemplate.getForObject("http://localhost:10900/server/user", User.class);
        log.info("通过RestTemplate获取用户信息{}", user);
        return user;
    }

    @GetMapping("guser")
    public User getUserByName(@RequestParam String name) {
        Map<String,String> map = new HashMap <>();
        map.put("name", name);
        User puser = restTemplate.getForObject("http://localhost:10900/server/guser/{name}", User.class, map);
        User user = restTemplate.getForObject("http://localhost:10900/server/guser?name={name}", User.class, map);
        log.info("通过RestTemplate根据用户名{}获取用户信息", name);
        return user;
    }

    @PostMapping("user")
    public String setUser(@RequestBody User user) {
        String msg = restTemplate.postForObject("http://localhost:10900/server/user", user, String.class);
        log.info("通过RestTemplate修改用户信息{}", user);
        return msg;
    }

}
