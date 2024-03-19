package com.example.sku_manager.application.usecases.productWithdrawals.productWithdrawalsService;

import com.example.sku_manager.application.dtos.productWithdrawalsDTOs.ProductWithdrawalsDTO;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.ProductWithdrawals;

public interface CreateProductWithdrawalsService {
    HttpResponses createProductWithdrawals(ProductWithdrawalsDTO data);
}
