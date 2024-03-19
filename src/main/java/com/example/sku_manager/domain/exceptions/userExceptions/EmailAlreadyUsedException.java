package com.example.sku_manager.domain.exceptions.userExceptions;

import com.example.sku_manager.domain.exceptions.DomainException;

public class EmailAlreadyUsedException extends DomainException {
    public EmailAlreadyUsedException(String message,Integer httpStatus){

        super(message, httpStatus);

    }
}

