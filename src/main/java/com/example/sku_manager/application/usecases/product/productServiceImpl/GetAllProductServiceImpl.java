package com.example.sku_manager.application.usecases.product.productServiceImpl;

import com.example.sku_manager.application.usecases.product.productService.GetAllProductService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Product;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetAllProductServiceImpl implements GetAllProductService {
     private  final ProductRepositoryDB productRepositoryDB;
     private  final HttpResponses httpResponse;

     public  GetAllProductServiceImpl(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponse){
         this.productRepositoryDB = productRepositoryDB;
         this.httpResponse = httpResponse;
     }

     @Autowired
    public HttpResponses getAllProducts(){
         List<Product> products = productRepositoryDB.findAll();
         httpResponse.setStatusCode(200);
         httpResponse.setBody(products);
         return httpResponse;
     }
}
