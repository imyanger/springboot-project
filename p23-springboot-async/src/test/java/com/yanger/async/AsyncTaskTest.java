package com.yanger.async;

import com.yanger.SpringbootApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author yanger
 * @description async异步执行测试类
 * @date 2019/10/15
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class AsyncTaskTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void doAsyncTasks(){
        //@Async异步必须通过Spring注入bean
        //AsyncTask asyncTask = new AsyncTask();
        try {
            long start = System.currentTimeMillis();
            asyncTask.taskOne();
            asyncTask.taskTwo();
            asyncTask.taskThree();
            Thread.sleep(5000);
            long end = System.currentTimeMillis();
            log.info("主程序执行完成耗时{}秒", (end - start)/1000f);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private FutureTask futureTask;

    @Test
    public void doFutureTasks(){
        try {
            long start = System.currentTimeMillis();
            Future <String> future1 = futureTask.taskOne();
            Future <String> future2 = futureTask.taskTwo();
            Future <String> future3 = futureTask.taskThree();
            //3个任务执行完成之后再执行主程序
            do {
                Thread.sleep(100);
            } while (future1.isDone() && future2.isDone() && future3.isDone());
            log.info("获取异步方法的返回值:{}", future1.get());
            Thread.sleep(5000);
            long end = System.currentTimeMillis();
            log.info("主程序执行完成耗时{}秒", (end - start)/1000f);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
