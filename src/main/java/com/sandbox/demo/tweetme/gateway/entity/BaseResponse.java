package com.sandbox.demo.tweetme.gateway.entity;

public abstract class BaseResponse<T> {
    protected long count;
    protected long timestamp;
    protected int code;
    protected T value;

    public long getCount() {
        return count;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getCode() {
        return code;
    }

    public T getValue() {
        return value;
    }
}
