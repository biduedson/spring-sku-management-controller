package com.example.sku_manager.application.usecases.advertisedProducts.AdvertisedProductsService;

import com.example.sku_manager.application.dtos.advertisedProductDTOs.AdvertisedProductDTOs;
import com.example.sku_manager.domain.HttpResponses;

public interface CreateAdvertisedProductsService {
    HttpResponses  createAdvertisedProduct(AdvertisedProductDTOs data);
}
