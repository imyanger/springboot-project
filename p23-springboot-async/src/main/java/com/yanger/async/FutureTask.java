package com.yanger.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author yanger
 * @description Future异步执行回调
 * @date 2019/10/15
 */
@Slf4j
@Component
public class FutureTask {

    private Random random = new Random();

    //@Async所修饰的函数不要定义为static类型，这样异步调用不会生效
    @Async
    public Future<String> taskOne() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("任务一执行完成耗时{}秒", (end - start)/1000f);
        return new AsyncResult <>("任务一Ok");
    }

    @Async
    public Future<String> taskTwo() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("任务二执行完成耗时{}秒", (end - start)/1000f);
        return new AsyncResult <>("任务二OK");
    }

    @Async
    public Future<String> taskThree() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("任务三执行完成耗时{}秒", (end - start)/1000f);
        return new AsyncResult <>("任务三Ok");
    }

}
