package com.example.sku_manager.domain.exceptions;



public abstract class DomainException extends RuntimeException {
    private  final Integer httpStatus;
    public DomainException(String message, Integer httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }

    public Integer getHttpStatus(){
        return httpStatus;
    }

}