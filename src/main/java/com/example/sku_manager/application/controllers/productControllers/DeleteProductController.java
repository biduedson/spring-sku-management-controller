package com.example.sku_manager.application.controllers.productControllers;

import com.example.sku_manager.application.dtos.productDTOs.DeleteProductDTO;
import com.example.sku_manager.application.usecases.product.productService.DeleteProductService;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class DeleteProductController {
    @Autowired
    DeleteProductService deleteProductService;

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody @Valid DeleteProductDTO data) {
        HttpResponses response = deleteProductService.deleteProduct(data);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
