package com.sandbox.demo.tweetme.gateway.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "messaging.exchange")
public class TopicExchangeProperties {
    private String name;
    private String routingKeyPattern;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoutingKeyPattern() {
        return routingKeyPattern;
    }

    public void setRoutingKeyPattern(String routingKeyPattern) {
        this.routingKeyPattern = routingKeyPattern;
    }
}
