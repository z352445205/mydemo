package com.example.demo.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Zhengyn
 * @description
 * @create 21/2/18 10:40
 */
@Component
public class Consumer {
    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("rabbitmq_queue"))
    public void process(String message) {
        System.err.println("消费者消费消息=====" + message);
    }
}
