package com.example.sku_manager.application.dtos.advertisedProductDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AdvertisedProductDTOs(
        Integer id,
        @NotNull
        Integer product_id,
        @NotBlank
        String advertise_link,
        @NotNull
        Date  publish_date,
        @NotNull
        Integer platform_id
) {
}
