package com.sandbox.demo.tweetme.gateway.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "messaging.modify-queue")
public class ModifyQueueProperties extends AbstractQueueProperties {
}
