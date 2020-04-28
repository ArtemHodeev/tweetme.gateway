package com.sandbox.demo.tweetme.gateway.entity;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class ListResponse<T> extends BaseResponse<List<T>> {
    public ListResponse(List<T> value) {
        this.value = value;
        this.count = value.size();
        this.timestamp = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        this.code = HttpStatus.OK.value();
    }
}
