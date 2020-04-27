package com.sandbox.demo.tweetme.gateway.api;

import com.sandbox.demo.tweetme.gateway.entity.SingleResponse;
import com.sandbox.demo.tweetme.gateway.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Controller
@Path("/tweet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TweetController {
    @Autowired
    MessageSender messageSender;

    @GET
    @Path("/ping")
    public SingleResponse<String> getPong() {
        messageSender.sendMessage("The 1st message");
        return new SingleResponse<>("pong");
    }
}
