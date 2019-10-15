package com.yanger.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yanger
 * @description 定时任务执行类
 * @date 2019/10/15
 */
@EnableScheduling
@Component
public class Task {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void taskOne(){
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

}
