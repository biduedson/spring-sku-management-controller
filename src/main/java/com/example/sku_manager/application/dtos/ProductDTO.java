package com.example.sku_manager.application.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProductDTO(
        Integer id,
        @NotBlank
        String sku,
        @NotBlank
        String name,
        @NotBlank
        String imgurl,
        @NotNull
        Integer quantity,

        Date date,
        @NotBlank
        String gtin,
        @NotBlank
        String properties
) {

}
