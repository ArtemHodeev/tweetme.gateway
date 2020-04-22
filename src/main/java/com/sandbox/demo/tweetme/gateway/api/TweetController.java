package com.sandbox.demo.tweetme.gateway.api;

import com.sandbox.demo.tweetme.gateway.entity.SingleResponse;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Controller
@Path("/tweet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TweetController {
    @GET
    @Path("/ping")
    public SingleResponse<String> getPong() {
        return new SingleResponse<>("pong");
    }
}
