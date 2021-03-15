package com.example.demo.demo.rabbitmq.provider;

import com.example.demo.rabbitmq.provider.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zhengyn
 * @description
 * @create 21/2/18 10:14
 */
@SpringBootTest
class ProducerTest {
    @Autowired
    Producer producer;

    @Test
    void produce() {
        producer.produce();
    }
}