package com.yanger.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanger
 * @description cache类controller
 * @date 2019/10/12
 */
@RestController
@RequestMapping("cache")
public class CacheApi {

    @Autowired
    private CacheService cacheService;

    @GetMapping("get")
    public User  get(@RequestParam int id){
        return cacheService.get(id);
    }

    @PostMapping("set")
    public User  set(@RequestParam int id, @RequestParam String code, @RequestParam String name){
        User u = new User(code, name);
        return cacheService.set(id, u);
    }

}
