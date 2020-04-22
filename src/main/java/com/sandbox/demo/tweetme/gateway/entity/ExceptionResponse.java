package com.sandbox.demo.tweetme.gateway.entity;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ExceptionResponse extends BaseResponse{
    private String errorMsg = "";

    public ExceptionResponse() {
        this.code = HttpStatus.BAD_REQUEST.value();
        this.count = 1;
        this.timestamp = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    public ExceptionResponse(String errorMsg){
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
