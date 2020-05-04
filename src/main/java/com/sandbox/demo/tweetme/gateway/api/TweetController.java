package com.sandbox.demo.tweetme.gateway.api;

import com.sandbox.demo.tweetme.gateway.dto.NewTweet;
import com.sandbox.demo.tweetme.gateway.dto.Tweet;
import com.sandbox.demo.tweetme.gateway.entity.ListResponse;
import com.sandbox.demo.tweetme.gateway.entity.SingleResponse;
import com.sandbox.demo.tweetme.gateway.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Controller
@Path("/tweet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TweetController {
    private TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GET
//    @Path("/ping")
    @RequestMapping("/ping")
    public String getPong() {
        return "pong";
    }

    @GET
    @Path("/{id}")
    public Tweet getTweet(@PathVariable("id") Long id) {
        return new Tweet();
    }

    @GET
    @Path("/top/{count}")
    public List<Tweet> getTopTweets(@PathVariable("count") Long count) {
        return Arrays.asList(new Tweet());
    }

    @PUT
    public String addTweet(@Valid NewTweet rawTweet) {
        tweetService.add(rawTweet);
        return "OK";
    }

    @POST
    public SingleResponse<String> updateTweet(@Valid Tweet tweet) {
        tweetService.update(tweet);
        return new SingleResponse<>("OK");
    }

    @DELETE
    @Path("/{id}")
    public SingleResponse<String> deleteTweet(@PathVariable("id") Long id) {
        return new SingleResponse<>("OK");
    }
}
