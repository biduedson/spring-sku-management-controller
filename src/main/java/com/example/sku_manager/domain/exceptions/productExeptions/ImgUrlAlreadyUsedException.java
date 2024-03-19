package com.example.sku_manager.domain.exceptions.productExeptions;

import com.example.sku_manager.domain.exceptions.DomainException;

public class ImgUrlAlreadyUsedException extends DomainException {
    public ImgUrlAlreadyUsedException(String message, Integer httpStatus){
        super(message, httpStatus);
    }
}
