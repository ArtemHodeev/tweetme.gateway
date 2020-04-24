package com.sandbox.demo.tweetme.gateway.configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "messaging")
public class RabbitConfiguration {
    @Value("modifyQueue.name")
    String mainQueue;

    @Value("exchange")
    String exchange;

    @Value("modifyQueue.durable")
    Boolean isDurable;

    @Value()

    @Bean
    public Queue rabbitQueue() {
        return new Queue(mainQueue, isDurable);
    }

    @Bean
    public TopicExchange topicExchange() {
        return ExchangeBuilder.topicExchange(exchange).build();
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(rabbitQueue()).to(topicExchange()).with(routingKey)
    }

}
