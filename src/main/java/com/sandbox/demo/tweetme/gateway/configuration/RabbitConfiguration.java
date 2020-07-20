package com.sandbox.demo.tweetme.gateway.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sandbox.demo.tweetme.gateway.configuration.properties.AmqpProperties;
import com.sandbox.demo.tweetme.gateway.configuration.properties.LogQueueProperties;
import com.sandbox.demo.tweetme.gateway.configuration.properties.ModifyQueueProperties;
import com.sandbox.demo.tweetme.gateway.configuration.properties.TopicExchangeProperties;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    @Autowired
    AmqpProperties amqpProperties;

    @Autowired
    ModifyQueueProperties modifyQueueProperties;

    @Autowired
    TopicExchangeProperties topicExchangeProperties;

    @Autowired
    LogQueueProperties logQueueProperties;

    @Autowired
    ObjectMapper objectMapper;

    @Bean
    @ConditionalOnMissingBean
    public ConnectionFactory rabbitConnectionFactory() throws Exception {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost(amqpProperties.getHost());
        cachingConnectionFactory.setPort(amqpProperties.getPort());
        cachingConnectionFactory.setUsername(amqpProperties.getUsername());
        cachingConnectionFactory.setPassword(amqpProperties.getPassword());
        cachingConnectionFactory.setVirtualHost(amqpProperties.getVirtualHost());

        return cachingConnectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, TopicExchange topicExchange) throws Exception {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(topicExchange.getName());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue tweetModifyQueue() {
        return new Queue(modifyQueueProperties.getName(), modifyQueueProperties.getDurable(),false, false);
    }

    @Bean
    public Queue tweetLogQueue() {
        return new Queue(logQueueProperties.getName(), logQueueProperties.getDurable(),false, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return ExchangeBuilder.topicExchange(topicExchangeProperties.getName()).build();
    }

    @Bean
    public Binding logBinding() {
        return BindingBuilder.bind(tweetLogQueue()).to(topicExchange()).with(topicExchangeProperties.getRoutingKeyPattern());
    }

    @Bean
    public Binding modifyBinding() {
        return BindingBuilder.bind(tweetModifyQueue()).to(topicExchange()).with(topicExchangeProperties.getRoutingKeyPattern());
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}
