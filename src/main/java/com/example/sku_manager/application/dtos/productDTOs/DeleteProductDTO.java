package com.example.sku_manager.application.dtos.productDTOs;

import jakarta.validation.constraints.NotNull;

public record DeleteProductDTO(
        @NotNull
        Integer id
) {
}
