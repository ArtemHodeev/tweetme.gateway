package com.sandbox.demo.tweetme.gateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewTweet implements Serializable {
    private static final long serialVersionUID = 4758219099907736290L;

    @NotNull
    private String body;

    public NewTweet(@JsonProperty("body") String body) {
        this.body = body;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
