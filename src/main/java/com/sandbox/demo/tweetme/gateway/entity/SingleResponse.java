package com.sandbox.demo.tweetme.gateway.entity;

public class SingleResponse<T> {
    private T value;
    private long count;

    public SingleResponse(T value, long count) {
        this.value = value;
        this.count = count;
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

    public void setCount(long count) {
        this.count = count;
    }
}
