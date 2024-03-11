package com.example.sku_manager.domain;

public class HttpResponses<T> {

    Integer statusCode;
    private T body;
    public HttpResponses() {
    }


    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
    public void setBody(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }

}
