package com.sandbox.demo.tweetme.gateway.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "messaging.log-queue")
public class LogQueueProperties {
    private String name;
    private Boolean durable;
    private String routingKey;

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public Boolean getDurable() {
        return durable;
    }

    public void setDurable(Boolean durable) {
        this.durable = durable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
