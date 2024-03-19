package com.example.sku_manager.domain.exceptions.productExeptions;

import com.example.sku_manager.domain.exceptions.DomainException;

public class NameAlreadyUsedException extends DomainException {
    public NameAlreadyUsedException(String message, Integer httpStatus){
        super(message, httpStatus);}
}
