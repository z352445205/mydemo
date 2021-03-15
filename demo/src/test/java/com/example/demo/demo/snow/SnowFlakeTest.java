package com.example.demo.demo.snow;

import com.example.demo.snow.SnowFlake;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zhengyn
 * @description
 * @create 21/1/19 21:42
 */
class SnowFlakeTest {

    @Test
    void nextId() {

        final SnowFlake snowFlake = new SnowFlake(1L, 1L);
        for (int i = 0; i < 100; i++) {
            System.err.println(snowFlake.nextId());

        }
    }
}