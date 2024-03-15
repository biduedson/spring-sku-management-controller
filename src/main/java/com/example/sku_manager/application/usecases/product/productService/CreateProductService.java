package com.example.sku_manager.application.usecases.product.productService;

import com.example.sku_manager.application.dtos.productDTOs.ProductDTO;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Product;

public interface CreateProductService {
    HttpResponses createProduct(ProductDTO data);
}
