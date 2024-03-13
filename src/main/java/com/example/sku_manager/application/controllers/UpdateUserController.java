package com.example.sku_manager.application.controllers;

import com.example.sku_manager.application.dtos.UpdateUserDTO;
import com.example.sku_manager.application.usecases.userServiceImpl.UpdateUserServiceImpl;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UpdateUserController {

    @Autowired
    UpdateUserServiceImpl updateUserServiceImpl;

    @PutMapping
    public ResponseEntity updateUser(@RequestBody @Valid UpdateUserDTO data){
        HttpResponses response = updateUserServiceImpl.updateUser(data);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());

    }
}
