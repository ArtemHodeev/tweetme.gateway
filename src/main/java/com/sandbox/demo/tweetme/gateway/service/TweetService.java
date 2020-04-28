package com.sandbox.demo.tweetme.gateway.service;

import com.sandbox.demo.tweetme.gateway.dto.NewTweet;
import com.sandbox.demo.tweetme.gateway.dto.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
    @Autowired
    MessageSender messageSender;

    public void add(NewTweet newTweet) {
        messageSender.sendMessage(newTweet);
    }

    public  void update(Tweet tweet) {
        messageSender.sendMessage(tweet);
    }
}
