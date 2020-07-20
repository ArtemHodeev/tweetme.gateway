package com.sandbox.demo.tweetme.gateway.api;

import com.sandbox.demo.tweetme.gateway.client.ManagerRestClient;
import com.sandbox.demo.tweetme.gateway.dto.NewTweet;
import com.sandbox.demo.tweetme.gateway.dto.Tweet;
import com.sandbox.demo.tweetme.gateway.entity.SingleResponse;
import com.sandbox.demo.tweetme.gateway.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Controller

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tweet")
public class TweetController {
//    private ManagerRestClient managerRestClient;
    private TweetService tweetService;


    public TweetController(TweetService tweetService/*, ManagerRestClient managerRestClient*/) {
        this.tweetService = tweetService;
//        this.managerRestClient = managerRestClient;
    }

    @GET
    @Path("/{id}")
    public Tweet getTweet(@PathVariable("id") Long id) {
        return new Tweet();
//        return managerRestClient.getTweet(id);
    }

    @GET
    @Path("/top/{count}")
    public List<Tweet> getTopTweets(@PathVariable("count") Long count) {
        return Arrays.asList(new Tweet());
    }

    @PUT
    public SingleResponse<String> addTweet(@Valid NewTweet rawTweet) {
        tweetService.add(rawTweet);
        return new SingleResponse<>("OK");
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
