package com.example.sku_manager.config;

import com.example.sku_manager.application.usecases.ProductUseCases;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCasesConfig {

    @Autowired
    private ProductUseCases productUseCases;

    @Bean
    public  static ProductUseCases productUseCases(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponse){
        return  new ProductUseCases(productRepositoryDB, httpResponse);
    }
}
