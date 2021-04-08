package com.example.demo.task;

import com.example.demo.config.ResponseVo.ResponseResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/26 16:45
 */
@RequestMapping("TaskChange")
@RestController
@Slf4j
@Api
public class TaskChange {
    private final DynamicScheduledTask dynamicScheduledTask;
    public TaskChange(DynamicScheduledTask dynamicScheduledTask) {
        this.dynamicScheduledTask = dynamicScheduledTask;
    }

    @PostMapping("/change/{id}")
    public ResponseResult change(@PathVariable Integer id){
        /*log.info( "更改为——————》 0/10 * * * * *");
        scheduledTaskDemo.setExpression("0/10 * * * * *");*/
        dynamicScheduledTask.startTask(id);
        return ResponseResult.successResult();
    }
}
