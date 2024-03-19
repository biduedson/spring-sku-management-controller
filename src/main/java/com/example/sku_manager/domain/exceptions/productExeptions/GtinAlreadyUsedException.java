package com.example.sku_manager.domain.exceptions.productExeptions;

import com.example.sku_manager.domain.exceptions.DomainException;

public class GtinAlreadyUsedException extends DomainException {
    public  GtinAlreadyUsedException(String message, Integer httpStatus){
        super(message, httpStatus);}
}
