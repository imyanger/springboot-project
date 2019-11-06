package com.yanger.actuator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanger
 * @description
 * @date 2019/11/5
 */
@RequestMapping("actuator")
@RestController
public class ActuatorApi {

    @RequestMapping("hello")
    public String Hello() {
        return "Hello actuator";
    }

}
