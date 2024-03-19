package com.example.sku_manager.application.controllers.productWithdrawalsController;

import com.example.sku_manager.application.dtos.productWithdrawalsDTOs.ProductWithdrawalsDTO;
import com.example.sku_manager.application.usecases.productWithdrawals.productWithdrawalsService.CreateProductWithdrawalsService;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/withdrawals")
public class CreateProductWithdrawalsController {

    @Autowired
    private CreateProductWithdrawalsService createProductWithdrawalsService;

    @PostMapping
    public ResponseEntity createProductWithdrawals(@RequestBody @Valid ProductWithdrawalsDTO data){
        HttpResponses responses = createProductWithdrawalsService.createProductWithdrawals(data);
        return  ResponseEntity.status(responses.getStatusCode()).body(responses.getBody());
    }
}
