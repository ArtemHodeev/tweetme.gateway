package com.sandbox.demo.tweetme.gateway.configuration;

import com.sandbox.demo.tweetme.gateway.api.TweetController;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class JerseyConfiguration extends ResourceConfig {
    @PostConstruct
    public void init() {
        register(TweetController.class);
        register(ApiExceptionHandler.class);
    }
}
