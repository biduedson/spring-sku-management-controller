package com.example.sku_manager.application.controllers.productControllers;

import com.example.sku_manager.application.usecases.product.productService.GetAllProductService;
import com.example.sku_manager.domain.HttpResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class AllProductsListController {

    @Autowired
    GetAllProductService getAllProductService;

    @GetMapping
    public ResponseEntity allProducts(){
        HttpResponses response = getAllProductService.getAllProducts();
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
