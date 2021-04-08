package com.example.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/26 16:27
 */
@Slf4j
@Configuration
@EnableScheduling
public class ScheduledTaskDemo {

    // cron表达式，我们动态更改此属性的值即可更改定时任务的执行时间
    private String expression = "0/5 * * * * *";

    //@Bean
    public SchedulingConfigurer schedulingConfigurer() {
        return taskRegistrar -> {
            // 定时任务要执行的方法
            Runnable task = () -> log.info(">>> configureTasks ...");
            // 调度实现的时间控制
            Trigger trigger = triggerContext -> {
                CronTrigger cronTrigger = new CronTrigger(expression);
                return cronTrigger.nextExecutionTime(triggerContext);
            };
            taskRegistrar.addTriggerTask(task, trigger);
        };
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }


    /**
     * 动态启用
     */
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        final ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadNamePrefix("threadPoolTaskScheduler-");
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
        return threadPoolTaskScheduler;
    }
}
