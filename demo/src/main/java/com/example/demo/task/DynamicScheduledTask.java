package com.example.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/26 17:12
 */
@Component
@Slf4j
public class DynamicScheduledTask {


    private final ThreadPoolTaskScheduler threadPoolTaskScheduler;

    public DynamicScheduledTask(final ThreadPoolTaskScheduler threadPoolTaskScheduler) {
        this.threadPoolTaskScheduler = threadPoolTaskScheduler;
    }

    private ConcurrentHashMap<Integer,ScheduledFuture> futures = new ConcurrentHashMap<>(10);

    /**
     * 启动定时器
     */
    public void startTask(Integer id) {
        // 第一个参数为定时任务要执行的方法，第二个参数为定时任务执行的时间
        ScheduledFuture  future = threadPoolTaskScheduler.schedule(()-> test(id), new CronTrigger("0/2 * * * * *"));
        futures.put(id,future);
    }

    /**
     * 停止定时器
     */
    public void endTask(Integer id) {
        final ScheduledFuture future = futures.get(id);
        if ( future!= null) {
            future.cancel(true);
        }
    }

    /**
     * 改变调度的时间，先停止定时器再启动新的定时器
     */
    public void changeTask(Integer id) {
        // 停止定时器
        endTask(id);
        // 定义新的执行时间,并启动
         futures.put(id,threadPoolTaskScheduler.schedule(()-> test(id), new CronTrigger("0/5 * * * * *")));
    }

    /**
     * 定时任务执行的方法
     */
    public void test(Integer id){
        log.info(">>> DynamicScheduledTask ..."+id);
    }
}
