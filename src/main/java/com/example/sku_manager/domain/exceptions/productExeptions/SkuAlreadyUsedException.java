package com.example.sku_manager.domain.exceptions.productExeptions;

import com.example.sku_manager.domain.exceptions.DomainException;

public class SkuAlreadyUsedException extends DomainException {
    public SkuAlreadyUsedException(String message, Integer httpStatus){super(message, httpStatus);}
}
