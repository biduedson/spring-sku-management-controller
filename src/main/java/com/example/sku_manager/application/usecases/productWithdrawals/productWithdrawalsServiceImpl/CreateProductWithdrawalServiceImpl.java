package com.example.sku_manager.application.usecases.productWithdrawals.productWithdrawalsServiceImpl;

import com.example.sku_manager.application.dtos.productWithdrawalsDTOs.ProductWithdrawalsDTO;
import com.example.sku_manager.application.usecases.product.productServiceImpl.CreateProductServiceImpl;
import com.example.sku_manager.application.usecases.productWithdrawals.productWithdrawalsService.CreateProductWithdrawalsService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Product;
import com.example.sku_manager.domain.ProductWithdrawals;
import com.example.sku_manager.domain.User;
import com.example.sku_manager.infrastructure.database.ProductRepositoryDB;
import com.example.sku_manager.infrastructure.database.ProductWithdrawalsRepositoryDB;
import com.example.sku_manager.infrastructure.database.UserRepositoryDB;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CreateProductWithdrawalServiceImpl implements CreateProductWithdrawalsService {

    private  final ProductWithdrawalsRepositoryDB productWithdrawalsRepositoryDB;
    private final ProductRepositoryDB productRepositoryDB;

    private  final UserRepositoryDB userRepositoryDB;
    private final HttpResponses httpResponses;

    public CreateProductWithdrawalServiceImpl(ProductWithdrawalsRepositoryDB productWithdrawalsRepositoryDB,ProductRepositoryDB productRepositoryDB,UserRepositoryDB userRepositoryDB, HttpResponses httpResponses){
        this.productWithdrawalsRepositoryDB= productWithdrawalsRepositoryDB;
        this.httpResponses = httpResponses;
        this.productRepositoryDB = productRepositoryDB;
        this.userRepositoryDB = userRepositoryDB;
    }

    @Override
    public HttpResponses createProductWithdrawals(ProductWithdrawalsDTO data){
        if(data.quantity() < 1){
            httpResponses.setStatusCode(400);
            httpResponses.setBody("A quantidade de produto a ser retirada não pode ser menos que 1.");
            return  httpResponses;
        }
        Optional<User> optimalUser = userRepositoryDB.findById(data.id_user());
       Optional<Product> optimalProduct = productRepositoryDB.findById(data.id_product());

        if(optimalUser.isPresent() && optimalProduct.isPresent()){

            User user = optimalUser.get();
            Product product = optimalProduct.get();
            if(product.getQuantity() < data.quantity()){
                httpResponses.setStatusCode(400);
                httpResponses.setBody("Não há quantidade suficiente de produto.");
                return httpResponses;
            }

            ProductWithdrawals newProductWithdrawals = new ProductWithdrawals(data.date(), data.quantity(), product, user);
            product.setQuantity(product.getQuantity() - data.quantity());
            productRepositoryDB.save(product);

            productWithdrawalsRepositoryDB.save(newProductWithdrawals);
            httpResponses.setStatusCode(201);
            httpResponses.setBody(newProductWithdrawals);
            return httpResponses;
        }else {
            httpResponses.setStatusCode(404);
            httpResponses.setBody(!optimalUser.isPresent()?"Usuario não encontrado." :
                                  !optimalProduct.isPresent()? "Produto não encontrado.":"");
            return  httpResponses;
        }

    }
}
