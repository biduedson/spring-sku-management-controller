package com.example.sku_manager.application.usecases.product.productServiceImpl;

import com.example.sku_manager.application.dtos.productDTOs.DeleteProductDTO;
import com.example.sku_manager.application.usecases.product.productService.DeleteProductService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductServiceImpl implements DeleteProductService {
    private  final ProductRepositoryDB productRepositoryDB;
    private  final HttpResponses httpResponse;

    public  DeleteProductServiceImpl(ProductRepositoryDB productRepositoryDB, HttpResponses httpResponse){
        this.productRepositoryDB = productRepositoryDB;
        this.httpResponse = httpResponse;
    }
    @Override
    public  HttpResponses deleteProduct(DeleteProductDTO data){
        boolean productNotExisting = !productRepositoryDB.findById(data.id()).isPresent();

        if(productNotExisting){
            httpResponse.setStatusCode(404);
            httpResponse.setBody("Produto não encontrado.");
            return httpResponse;
        }
        productRepositoryDB.deleteById(data.id());
        httpResponse.setStatusCode(200);
        httpResponse.setBody("Produto deletado com sucesso.");
        return  httpResponse;

    }
}
