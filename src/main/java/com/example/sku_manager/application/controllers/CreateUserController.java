package com.example.sku_manager.application.controllers;

import com.example.sku_manager.application.dtos.CreateUserUserDTO;
import com.example.sku_manager.application.usecases.userServiceImpl.CreateUserServiceImpl;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class CreateUserController {
    @Autowired
    private CreateUserServiceImpl createUserServiceImpl;
    @PostMapping
    public ResponseEntity newUser(@RequestBody @Valid CreateUserUserDTO data){
        HttpResponses response = createUserServiceImpl.createUser(data);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
