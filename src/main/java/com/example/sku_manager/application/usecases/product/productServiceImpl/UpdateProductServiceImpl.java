package com.example.sku_manager.application.usecases.product.productServiceImpl;

import com.example.sku_manager.application.dtos.productDTOs.ProductDTO;
import com.example.sku_manager.application.usecases.product.productService.UpdateProductService;
import com.example.sku_manager.application.usecases.user.userService.UpdateUserService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Product;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;
import java.util.Optional;
public class UpdateProductServiceImpl implements UpdateProductService {
    public ProductRepositoryDB productRepositoryDB;
    public HttpResponses httpResponse;


    public UpdateProductServiceImpl(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponse){
        this.httpResponse = httpResponse;
        this.productRepositoryDB = productRepositoryDB;

    }
    @Override
    public HttpResponses updateProduct(ProductDTO data){
     boolean nameExisting = productRepositoryDB.findByName(data.name()) != null;
     boolean skuExisting = productRepositoryDB.findBySku(data.sku()) != null;
     boolean imgUrlExisting = productRepositoryDB.findByImgurl(data.imgurl()) != null;
     boolean gtinExisting = productRepositoryDB.findByGtin(data.gtin()) != null;
     Optional<Product> optinalProduct = productRepositoryDB.findById(data.id());

     if(optinalProduct.isPresent()){
         Product product = optinalProduct.get();
         String fieldName;
         if(nameExisting || skuExisting || imgUrlExisting || gtinExisting){
             httpResponse.setStatusCode(400);
             if(product.getName().equals(data.name())  ||
                     product.getSku().equals(data.sku())   ||
                     product.getImgurl().equals(data.imgurl())  ||
                     product.getGtin().equals(data.gtin())){

                 fieldName = product.getName().equals(data.name()) ? "name" :
                                   product.getSku().equals(data.sku()) ? "sku":
                                     product.getImgurl().equals(data.imgurl()) ? "imgurl":
                                             product.getGtin().equals(data.gtin()) ? "gtin":"";

                 httpResponse.setBody("O novo " + fieldName + " deve ser diferento do " + fieldName + " atual.");
                 return httpResponse;

             }
             fieldName = nameExisting? "nome" : skuExisting ? "sku" : imgUrlExisting? "imgurl" :gtinExisting ? "gtin" : "";
             httpResponse.setBody("Ja existe um " + fieldName + " cadastrado." );
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
             return httpResponse;
     }else {
         httpResponse.setStatusCode(404);
         httpResponse.setBody("Produto não encontrado.");
         return  httpResponse;
     }

    }
}
