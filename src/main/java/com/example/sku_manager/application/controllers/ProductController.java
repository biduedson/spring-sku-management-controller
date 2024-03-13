package com.example.sku_manager.application.controllers;

import com.example.sku_manager.application.dtos.ProductDTO;
import com.example.sku_manager.application.usecases.ProductUseCases;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductUseCases productUseCases;

    @PostMapping
    public ResponseEntity  newProduct(@RequestBody @Valid ProductDTO data){
        HttpResponses response = productUseCases.newProduct(data);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping
    public  ResponseEntity allProducts(){
        HttpResponses response = productUseCases.allProducts();
        return  ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
