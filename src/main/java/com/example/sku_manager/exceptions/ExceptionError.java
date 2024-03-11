package com.example.sku_manager.exceptions;

public class ExceptionError {
    String message;

    public  ExceptionError(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

}

