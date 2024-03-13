package com.example.sku_manager.application.usecases;

import com.example.sku_manager.application.dtos.ProductDTO;
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


    public  HttpResponses allProducts(){
        List<Product> products = productRepositoryDB.findAll();
           httpResponse.setStatusCode(200);
           httpResponse.setBody(products);
           return httpResponse;
    }
    public  HttpResponses newProduct(ProductDTO data){
      Product product2 = productRepositoryDB.findBySku(data.sku());
      System.out.println(data.sku() +  product2);
      if(checkNameExistsByName(data.name())){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Já existe um produto cadastrado com este nome.");
            return httpResponse;
      }

      if(checkSkuExistsByName(data.sku())){
          httpResponse.setStatusCode(400);
          httpResponse.setBody("Já existe um sku cadastrado com este sku.ja esta cadastrado.");
          return  httpResponse;
      }

      if(checkImgUrlExistsByName(data.imgurl())){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Já existe uma imagem cadastrado com esta url.");
            return  httpResponse;
      }

        if(checkGtinExistsByName(data.gtin())){
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
