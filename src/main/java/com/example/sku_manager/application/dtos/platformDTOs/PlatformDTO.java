package com.example.sku_manager.application.dtos.platformDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlatformDTO(

        Integer id,
        @NotBlank
        String name,
        @NotBlank
        String imgurl
) {
}
