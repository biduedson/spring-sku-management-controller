package com.example.sku_manager.application.usecases.product.productService;

import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Product;

public interface GetAllProductService {
    HttpResponses getAllProducts();
}
