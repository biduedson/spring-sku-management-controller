package com.example.sku_manager.application.usecases.advertisedProducts.AdvertisedProductsServiceImpl;

import com.example.sku_manager.application.dtos.advertisedProductDTOs.AdvertisedProductDTOs;
import com.example.sku_manager.application.usecases.advertisedProducts.AdvertisedProductsService.CreateAdvertisedProductsService;
import com.example.sku_manager.domain.AdvertisedProduct;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Platform;
import com.example.sku_manager.domain.Product;
import com.example.sku_manager.domain.exceptions.platform.AlreadyUsedException;
import com.example.sku_manager.infrastructure.database.AdvertisedProductDB;
import com.example.sku_manager.infrastructure.database.PlatformRepositoryDB;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CreateAdvertisedProductServiceImpl implements CreateAdvertisedProductsService {
    private final AdvertisedProductDB advertisedProductDB;
    private final ProductRepositoryDB productRepositoryDB;

    private final PlatformRepositoryDB platformRepositoryDB;

    private  final HttpResponses httpResponses;

    public CreateAdvertisedProductServiceImpl(AdvertisedProductDB advertisedProductDB, ProductRepositoryDB productRepositoryDB, PlatformRepositoryDB platformRepositoryDB, HttpResponses httpResponses){
        this.advertisedProductDB =  advertisedProductDB;
        this.productRepositoryDB = productRepositoryDB;
        this.platformRepositoryDB = platformRepositoryDB;
        this.httpResponses = httpResponses;
    }
    @Override
    public HttpResponses createAdvertisedProduct(AdvertisedProductDTOs data){
        boolean checkAdvertiseLinkExistsByName = advertisedProductDB.existsByAdvertiseLink(data.advertise_link());
        if(checkAdvertiseLinkExistsByName){
            throw  new AlreadyUsedException("Esta url ja esta sendo usada.", 409);
        }
        Optional<Product> optionalAdvertisedProduct = productRepositoryDB.findById(data.product_id());
        Optional<Platform> optionalPlatform = platformRepositoryDB.findById(data.platform_id());

        if (optionalAdvertisedProduct.isPresent() && optionalPlatform.isPresent()){
            Product product = optionalAdvertisedProduct.get();
            Platform platform = optionalPlatform.get();
            AdvertisedProduct newAdvertisedProduct = new AdvertisedProduct(data.id(), product, data.advertise_link(),data.publish_date(),platform );
            advertisedProductDB.save(newAdvertisedProduct);
            httpResponses.setStatusCode(201);
            httpResponses.setBody(newAdvertisedProduct);
            return  httpResponses;
        }else {
            httpResponses.setStatusCode(404);
            httpResponses.setBody(!optionalAdvertisedProduct.isPresent()?"Produto não encontrado":"Plataforma não encontrada.");
            return  httpResponses;
        }


    }
}
