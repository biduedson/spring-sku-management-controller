package com.example.sku_manager.application.usecases;

import com.example.sku_manager.application.dtos.productDTOs.ProductDTO;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Product;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;

import java.util.List;
import java.util.Optional;

public class ProductUseCases {

    private  final ProductRepositoryDB productRepositoryDB;

    private  final HttpResponses httpResponse;

    public ProductUseCases(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponse){
        this.productRepositoryDB = productRepositoryDB;
        this.httpResponse = httpResponse;

    }




    public HttpResponses updateProduct(ProductDTO data){
        if(checkProductExists(data.id())){
            httpResponse.setStatusCode(404);
            httpResponse.setBody("Produto não encontrado.");
            return  httpResponse;
        }
        return  httpResponse;
    }

public boolean checkProductExists(Integer id){
    Optional<Product> optionalProduct = productRepositoryDB.findById(id);
    Product product =optionalProduct.orElse(null);
    return optionalProduct.get() != null;
}
    public boolean checkNameExistsByName(String name){
        Product product = productRepositoryDB.findByName(name);
        return  product != null;
    }

    public boolean checkSkuExistsByName(String sku){
        Product product = productRepositoryDB.findBySku(sku);
        return  product != null;
    }

    public boolean checkImgUrlExistsByName(String imgurl){
        Product product = productRepositoryDB.findByImgurl(imgurl);
        return  product != null;
    }

    public boolean checkGtinExistsByName(String gtin){
        Product product = productRepositoryDB.findByGtin(gtin);
        return  product != null;
    }

}
