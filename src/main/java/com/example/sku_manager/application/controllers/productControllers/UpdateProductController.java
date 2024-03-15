package com.example.sku_manager.application.controllers.productControllers;

import com.example.sku_manager.application.dtos.productDTOs.ProductDTO;
import com.example.sku_manager.application.usecases.product.productService.UpdateProductService;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class UpdateProductController {

    @Autowired
    UpdateProductService updateProductService;

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Valid ProductDTO data){
        HttpResponses response = updateProductService.updateProduct(data);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
