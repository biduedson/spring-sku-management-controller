package com.example.sku_manager.application.controllers;

import com.example.sku_manager.application.dtos.DeleteUserDTO;
import com.example.sku_manager.application.usecases.userServiceImpl.DeleteUserServiceImpl;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class DeleteUserController {
    @Autowired
    private DeleteUserServiceImpl deleteUserServiceImpl;
@DeleteMapping
    public ResponseEntity DeleteUserServiceImpl(@RequestBody  DeleteUserDTO data){
        HttpResponses responses = deleteUserServiceImpl.deleteUser(data);
        return  ResponseEntity.status(responses.getStatusCode()).body(responses.getBody());
    }
}
