package com.example.demo.demo.redis.testPackage.service;

import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Zhengyn
 * @description
 * @create 21/3/10 11:19
 */
@SpringBootTest
class TestStudent1ServiceTest {


    public static void main(String[] args) {
        final double v = NumberUtil.mul(NumberUtil.div("6", "555", 3).doubleValue(),100);
        System.err.println(v);
    }
}