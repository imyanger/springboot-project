package com.yanger.log;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanger
 * @description 测试日志输出
 * @date 2019/10/17
 */
@Slf4j
@RestController
@RequestMapping("log")
public class LogApi {

    @GetMapping("print")
    public void print(){
        log.error("-------------------error日志打印" );
        log.warn("-------------------warn日志打印");
        log.info("-------------------info日志打印");
        log.debug("-------------------debug日志打印");
    }

}
