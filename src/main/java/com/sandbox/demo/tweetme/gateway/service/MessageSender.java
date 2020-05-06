package com.sandbox.demo.tweetme.gateway.service;

import com.sandbox.demo.tweetme.gateway.configuration.properties.ModifyQueueProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    ModifyQueueProperties modifyQueueProperties;

    public <T> void sendMessage(T message) {
        rabbitTemplate.convertAndSend(modifyQueueProperties.getRoutingKey(), message);
    }
}
