package com.example.sku_manager.application.dtos;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserDTO(
        Integer id,
        @NotBlank
        String username,

        @NotBlank
        String email
) {
}
