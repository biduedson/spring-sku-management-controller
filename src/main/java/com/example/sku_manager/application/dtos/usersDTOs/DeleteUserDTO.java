package com.example.sku_manager.application.dtos.usersDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DeleteUserDTO(
        Integer id
) {
}
