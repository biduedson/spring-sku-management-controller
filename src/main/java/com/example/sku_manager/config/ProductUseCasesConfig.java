package com.example.sku_manager.config;

import com.example.sku_manager.application.usecases.ProductUseCases;
import com.example.sku_manager.application.usecases.product.productServiceImpl.CreateProductServiceImpl;
import com.example.sku_manager.application.usecases.product.productServiceImpl.DeleteProductServiceImpl;
import com.example.sku_manager.application.usecases.product.productServiceImpl.GetAllProductServiceImpl;
import com.example.sku_manager.application.usecases.product.productServiceImpl.UpdateProductServiceImpl;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCasesConfig {
    @Bean
    public  static ProductUseCases productUseCases(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponse){
        return  new ProductUseCases(productRepositoryDB, httpResponse);
    }

    @Bean
    public static CreateProductServiceImpl createProductServiceImpl(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponse){
        return  new CreateProductServiceImpl(productRepositoryDB, httpResponse);
    }

    @Bean
    public  static GetAllProductServiceImpl getAllProductServiceImpl(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponses){
        return  new GetAllProductServiceImpl(productRepositoryDB,httpResponses);
    }

    @Bean
    public  static DeleteProductServiceImpl deleteProductServiceImpl(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponses){
        return new DeleteProductServiceImpl(productRepositoryDB, httpResponses);
    }

    @Bean
    public static UpdateProductServiceImpl updateProductServiceimpl(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponses){
        return  new UpdateProductServiceImpl(productRepositoryDB,httpResponses);
    }
}
