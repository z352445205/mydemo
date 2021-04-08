package com.example.demo.observerMode;

import io.swagger.models.Tag;
import org.apiguardian.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.apiguardian.api.API.Status.STABLE;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/8 22:10
 */
@RestController
@RequestMapping("user")
@API(status = STABLE, consumers = "观察者模式用户注册")
public class UserRegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(@RequestParam String username) {
        userService.register(username);
        return "success";
    }

}
