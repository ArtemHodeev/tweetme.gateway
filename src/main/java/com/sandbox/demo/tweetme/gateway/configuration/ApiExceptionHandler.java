package com.sandbox.demo.tweetme.gateway.configuration;

import com.sandbox.demo.tweetme.gateway.entity.ExceptionResponse;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.Response;

@Component
public class ApiExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception ex) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ExceptionResponse(ex))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
