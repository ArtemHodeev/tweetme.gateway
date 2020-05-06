package com.sandbox.demo.tweetme.gateway.service;

import com.sandbox.demo.tweetme.gateway.dto.NewTweet;
import com.sandbox.demo.tweetme.gateway.dto.Tweet;
import com.sandbox.demo.tweetme.gateway.dto.TweetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TweetService {
    @Autowired
    MessageSender messageSender;

    public void add(NewTweet newTweet) {
        Tweet tweet = new Tweet();
        tweet.setBody(newTweet.getBody());
        tweet.setCreationDate(LocalDateTime.now());
        tweet.setTweetType(TweetType.ORIGINAL);

        messageSender.sendMessage(tweet);
    }

    public  void update(Tweet tweet) {
        messageSender.sendMessage(tweet);
    }
}
