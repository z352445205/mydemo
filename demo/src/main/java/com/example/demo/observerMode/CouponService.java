package com.example.demo.observerMode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author Zhengyn
 * @description
 * @create 21/4/8 22:08
 */
@Service
@Slf4j
public class CouponService {


    @EventListener // <1>
    public void addCoupon(UserRegisterEvent event) {
        log.info("[addCoupon][给用户({}) 发放优惠劵]", event.getUsername());
    }

}

