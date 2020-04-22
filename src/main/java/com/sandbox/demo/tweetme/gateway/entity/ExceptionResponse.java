package com.sandbox.demo.tweetme.gateway.entity;

public class ExceptionResponse {
    private String errorMsg = "";

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ExceptionResponse(){}
    public ExceptionResponse(String errorMsg){
        this.errorMsg = errorMsg;
    }
}
