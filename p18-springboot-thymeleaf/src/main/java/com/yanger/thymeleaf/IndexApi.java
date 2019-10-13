package com.yanger.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2019/10/11.
 */
@Controller
@RequestMapping("index")
public class IndexApi {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/mv")
    public ModelAndView mv(){
        ModelAndView mv = new ModelAndView("mv");
        mv.addObject("name","yanger");
        return mv;
    }

}
