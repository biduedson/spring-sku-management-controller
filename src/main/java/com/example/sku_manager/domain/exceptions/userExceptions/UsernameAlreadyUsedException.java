package com.example.sku_manager.domain.exceptions.userExceptions;

import com.example.sku_manager.domain.exceptions.DomainException;

public class UsernameAlreadyUsedException extends DomainException {
    public UsernameAlreadyUsedException(String message, Integer httpStatus){
        super(message, httpStatus);}
}
