package com.sandbox.demo.tweetme.gateway.entity;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SingleResponse<T> extends BaseResponse<T> {
    public SingleResponse(T value) {
        this.value = value;
        this.count = 1;
        this.timestamp = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        this.code = HttpStatus.OK.value();
    }


}
