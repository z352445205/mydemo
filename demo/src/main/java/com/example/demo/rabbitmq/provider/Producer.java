package com.example.demo.rabbitmq.provider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Zhengyn
 * @description
 * @create 21/2/18 10:13
 */
@Component
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void produce() {
        String message = LocalDateTime.now() + "Beijing";
        System.out.println("生产者生产消息=====" + message);
        rabbitTemplate.convertAndSend("rabbitmq_queue", message);
    }
}
