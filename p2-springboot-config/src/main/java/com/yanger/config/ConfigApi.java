package com.yanger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("config")
public class ConfigApi {

    @Value("${my.name}")
    private String name;

    @GetMapping("getName")
    public String getName(){
        return "@Value get name:" + name;
    }

    @Autowired
    private Girl girl;

    @GetMapping("getGirl")
    public String getGirl(){
        return "@ConfigurationProperties get girl:" + girl.getName() + "--" + girl.getAge();
    }

    @Autowired
    private Boy boy;

    @GetMapping("getBoy")
    public String getBoy(){
        return "@ConfigurationProperties get boy:" + boy.getName() + "--" + boy.getAge();
    }

}
