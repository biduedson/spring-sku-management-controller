package com.example.sku_manager.application.controllers.advertisedProductControllers;

import com.example.sku_manager.application.dtos.advertisedProductDTOs.AdvertisedProductDTOs;
import com.example.sku_manager.application.usecases.advertisedProducts.AdvertisedProductsService.CreateAdvertisedProductsService;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("advertised_product")
public class CreateAdvertisedProductController {
    private final CreateAdvertisedProductsService createAdvertisedProductsService;

    public CreateAdvertisedProductController(CreateAdvertisedProductsService createAdvertisedProductsService){
        this.createAdvertisedProductsService = createAdvertisedProductsService;
    }

    @PostMapping
    public ResponseEntity createAdvertisedProduct(@RequestBody @Valid AdvertisedProductDTOs data){
        HttpResponses responses = createAdvertisedProductsService.createAdvertisedProduct(data);
        return ResponseEntity.status(responses.getStatusCode()).body(responses.getBody());
    }
}
