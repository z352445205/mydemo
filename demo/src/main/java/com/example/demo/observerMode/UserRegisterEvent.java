package com.example.demo.observerMode;

import org.springframework.context.ApplicationEvent;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/8 22:06
 */
public class UserRegisterEvent extends ApplicationEvent {

    /**
     * 用户名
     */
    private String username;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
