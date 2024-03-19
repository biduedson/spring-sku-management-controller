package com.example.sku_manager.application.usecases.product.productServiceImpl;

import com.example.sku_manager.application.dtos.productDTOs.ProductDTO;
import com.example.sku_manager.application.usecases.product.productService.CreateProductService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Product;
import com.example.sku_manager.domain.exceptions.productExeptions.GtinAlreadyUsedException;
import com.example.sku_manager.domain.exceptions.productExeptions.ImgUrlAlreadyUsedException;
import com.example.sku_manager.domain.exceptions.productExeptions.NameAlreadyUsedException;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;
import org.springframework.stereotype.Service;

@Service
public class CreateProductServiceImpl implements CreateProductService {

    private  final ProductRepositoryDB productRepositoryDB;
    private final HttpResponses httpResponse;

    public  CreateProductServiceImpl(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponse){
        this.productRepositoryDB = productRepositoryDB;
        this.httpResponse=httpResponse;
    }

    @Override
    public  HttpResponses createProduct(ProductDTO data){
        boolean checkImgUrlExistsByName = productRepositoryDB.existsByName(data.name());
        boolean checkGtinExistsByName = productRepositoryDB.existsByGtin(data.gtin());
        boolean checkSkuExistsByName = productRepositoryDB.existsBySku(data.sku());
        boolean checkImgurlExistsByName = productRepositoryDB.existsByImgurl(data.imgurl());

        if(checkImgUrlExistsByName){
            throw new NameAlreadyUsedException("Este nome já está sendo usado por outro produto.", 409);
        }

        if(checkSkuExistsByName){
            throw new NameAlreadyUsedException("Este sku já está sendo usado por outro produto.", 409);
        }

        if(checkImgurlExistsByName){
            throw new ImgUrlAlreadyUsedException("Esta url de imagem já esta sendo usada em outro produto.", 409);
        }
        if(checkGtinExistsByName){
            throw new GtinAlreadyUsedException("Este gtin já está sendo usado por  outro produto.", 409);
        }

        Product product = new Product( data.name(), data.quantity(),data.date(), data.sku(), data.imgurl(), data.gtin(), data.properties() );
        productRepositoryDB.save(product);
        httpResponse.setStatusCode(201);
        httpResponse.setBody(product);
        return  httpResponse;
    }
}

