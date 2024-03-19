package com.example.sku_manager.application.usecases.product.productServiceImpl;

import com.example.sku_manager.application.dtos.productDTOs.ProductDTO;
import com.example.sku_manager.application.usecases.product.productService.UpdateProductService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Product;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UpdateProductServiceImpl implements UpdateProductService {
    public ProductRepositoryDB productRepositoryDB;
    public HttpResponses httpResponse;


    public UpdateProductServiceImpl(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponse){
        this.httpResponse = httpResponse;
        this.productRepositoryDB = productRepositoryDB;

    }
    @Override
    public HttpResponses updateProduct(ProductDTO data){

     Optional<Product> optinalProduct = productRepositoryDB.findById(data.id());


     if(optinalProduct.isPresent()){
         Product product = optinalProduct.get();
         boolean nameExisting = productRepositoryDB.existsByName(data.name()) && !data.name().equals(product.getName());
         boolean skuExisting = productRepositoryDB.existsBySku(data.sku()) && !data.sku().equals(product.getSku());;
         boolean imgUrlExisting = productRepositoryDB.existsByImgurl(data.imgurl()) && !data.imgurl().equals(product.getImgurl());;
         boolean gtinExisting = productRepositoryDB.existsByGtin(data.gtin()) && !data.gtin().equals(product.getGtin());;

         String[] fieldName = {"nome","sku","imgurl","gtin"};
         if(nameExisting || skuExisting || imgUrlExisting || gtinExisting){
             httpResponse.setStatusCode(400);

             boolean[]fieldExisting = {nameExisting, skuExisting, imgUrlExisting, gtinExisting};
             for(int i =0; i < fieldExisting.length; i++){
                 if(fieldExisting[i]){
                     httpResponse.setBody("Ja existe um " + fieldName[i] + " cadastrado." );
                     break;
                 }
             }

             return httpResponse;

         }
             product.setName(data.name());
             product.setQuantity(data.quantity());
             product.setDate(data.date());
             product.setSku(data.sku());
             product.setImgurl(data.imgurl());
             product.setGtin(data.gtin());
             product.setProperties(data.properties());
             Product productUpdated = productRepositoryDB.save(product);
             httpResponse.setStatusCode(200);
             httpResponse.setBody("Produto atualizado com sucesso.");
     }else {
         httpResponse.setStatusCode(404);
         httpResponse.setBody("Produto não encontrado.");
     }
        return httpResponse;

    }
}
