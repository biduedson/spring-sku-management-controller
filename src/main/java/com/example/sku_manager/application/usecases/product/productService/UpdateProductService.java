package com.example.sku_manager.application.usecases.product.productService;

import com.example.sku_manager.application.dtos.productDTOs.ProductDTO;
import com.example.sku_manager.domain.HttpResponses;

public interface UpdateProductService {
    HttpResponses updateProduct(ProductDTO data);
}
