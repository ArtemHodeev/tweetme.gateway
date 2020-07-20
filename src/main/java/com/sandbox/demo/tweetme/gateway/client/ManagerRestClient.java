package com.sandbox.demo.tweetme.gateway.client;

import com.sandbox.demo.tweetme.gateway.configuration.properties.ManagerProperties;
import com.sandbox.demo.tweetme.gateway.dto.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@Component
public class ManagerRestClient {
    @Autowired
    private ManagerProperties managerProperties;
    private WebTarget webTarget;

    @PostConstruct
    public void init() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(managerProperties.getHost())
                .port(managerProperties.getPort())
                .build();
        webTarget = ClientBuilder.newClient().target(uriComponents.toUri());
    }

    public Tweet getTweet(Long id) {
        Tweet responseEntity = webTarget.path("api/read/" + id)
                .request()
                .get(Tweet.class);
        return responseEntity;
    }
}
