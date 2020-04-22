package com.sandbox.demo.tweetme.gateway.entity;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SingleResponse<T> extends BaseResponse{
    private T value;

    public SingleResponse(T value) {
        this.value = value;
        this.count = 1;
        this.timestamp = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        this.code = HttpStatus.OK.value();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public long getCount() {
        return count;
    }

    protected void setCount(long count) {
        this.count = count;
    }
}
