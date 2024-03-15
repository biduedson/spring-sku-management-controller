package com.example.sku_manager.application.controllers.productControllers;

import com.example.sku_manager.application.dtos.productDTOs.ProductDTO;
import com.example.sku_manager.application.usecases.product.productService.CreateProductService;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class CreateProductController {

    @Autowired
    CreateProductService createProductService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid ProductDTO data){
        HttpResponses response = createProductService.createProduct(data);
        return  ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

}
