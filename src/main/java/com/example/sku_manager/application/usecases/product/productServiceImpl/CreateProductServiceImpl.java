package com.example.sku_manager.application.usecases.product.productServiceImpl;

import com.example.sku_manager.application.dtos.productDTOs.ProductDTO;
import com.example.sku_manager.application.usecases.product.productService.CreateProductService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Product;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;

public class CreateProductServiceImpl implements CreateProductService {

    private  final ProductRepositoryDB productRepositoryDB;
    private HttpResponses httpResponse;

    public  CreateProductServiceImpl(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponse){
        this.productRepositoryDB = productRepositoryDB;
        this.httpResponse=httpResponse;
    }

    @Override
    public  HttpResponses createProduct(ProductDTO data){
        boolean checkSkuExistsByName = productRepositoryDB.findBySku(data.sku()) !=null;
        boolean checkNameExistsByName = productRepositoryDB.findByName(data.name()) != null;
        boolean checkImgUrlExistsByName = productRepositoryDB.findByImgurl(data.imgurl()) != null;
        boolean checkGtinExistsByName = productRepositoryDB.findByGtin(data.gtin()) != null;

        if(checkNameExistsByName){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Já existe um produto cadastrado com este nome.");
            return httpResponse;
        }

        if(checkSkuExistsByName){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Já existe um sku cadastrado com este sku.ja esta cadastrado.");
            return  httpResponse;
        }

        if(checkImgUrlExistsByName){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Já existe uma imagem cadastrado com esta url.");
            return  httpResponse;
        }

        if(checkGtinExistsByName){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Já existe um gtin cadastrado com este gtin.");
            return  httpResponse;
        }
        Product product = new Product( data.name(), data.quantity(),data.date(), data.sku(), data.imgurl(), data.gtin(), data.properties() );
        productRepositoryDB.save(product);
        httpResponse.setStatusCode(201);
        httpResponse.setBody(product);
        return  httpResponse;
    }
}

