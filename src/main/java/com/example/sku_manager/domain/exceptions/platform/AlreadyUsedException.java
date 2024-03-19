package com.example.sku_manager.domain.exceptions.platform;

import com.example.sku_manager.domain.exceptions.DomainException;

public class AlreadyUsedException extends DomainException {
    public AlreadyUsedException(String message, Integer httpStatus){
        super(message,httpStatus);
    }
}
