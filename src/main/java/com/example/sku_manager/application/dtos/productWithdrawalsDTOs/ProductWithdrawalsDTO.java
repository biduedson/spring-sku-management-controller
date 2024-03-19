package com.example.sku_manager.application.dtos.productWithdrawalsDTOs;

import com.example.sku_manager.domain.Product;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProductWithdrawalsDTO(
        Integer id,
        Date date,
        @NotNull
        Integer quantity,
        @NotNull
        Integer id_product,
        @NotNull
        Integer id_user
) {
}
