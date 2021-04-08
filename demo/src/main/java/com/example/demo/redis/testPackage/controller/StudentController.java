package com.example.demo.redis.testPackage.controller;


import com.example.demo.config.ResponseVo.ResponseResult;
import com.example.demo.redis.testPackage.entity.Student;
import com.example.demo.redis.testPackage.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Zhengyn
 * @since 2021-03-15
 */
@RestController
@RequestMapping("redis")
@Api(tags = "redisTestStudent")
@Slf4j
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("get")
    @ApiModelProperty(name = "getStudent")
    public ResponseResult<Student> getStudet(@RequestBody Student student) {
        log.info("");
        return ResponseResult.successResult(studentService.get(1));
    }
}
