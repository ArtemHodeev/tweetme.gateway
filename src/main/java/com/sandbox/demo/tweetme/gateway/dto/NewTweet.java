package com.sandbox.demo.tweetme.gateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewTweet implements Serializable {
    private static final long serialVersionUID = 4758219099907736290L;
    @NotBlank
    private String title;

    @NotNull
    private String body;

    public NewTweet(@JsonProperty("title") String title,
                    @JsonProperty("body") String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
