package com.example.sku_manager.application.usecases.product.productService;

import com.example.sku_manager.application.dtos.productDTOs.DeleteProductDTO;
import com.example.sku_manager.domain.HttpResponses;

public interface DeleteProductService {
HttpResponses deleteProduct(DeleteProductDTO data);
}
