package com.example.sku_manager.application.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DeleteUserDTO(
        Integer id
) {
}
