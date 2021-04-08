package com.example.demo.observerMode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/8 22:07
 */
@Service
@Slf4j
public class EmailService implements ApplicationListener<UserRegisterEvent> { // <1>

    @Override
    @Async // <3>
    public void onApplicationEvent(UserRegisterEvent event) { // <2>
        log.info("[onApplicationEvent][给用户({}) 发送邮件]", event.getUsername());
    }

}

