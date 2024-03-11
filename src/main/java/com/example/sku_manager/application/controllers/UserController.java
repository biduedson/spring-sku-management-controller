package com.example.sku_manager.application.controllers;

import com.example.sku_manager.application.dtos.DeleteUserDTO;
import com.example.sku_manager.application.dtos.UpdateUserDTO;
import com.example.sku_manager.application.usecases.UserUseCases;
import com.example.sku_manager.application.dtos.CreateUserUserDTO;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserUseCases userUseCases;
    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid CreateUserUserDTO data){
        HttpResponses response = userUseCases.newUser(data);
        return  ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        var allUsers = userUseCases.allUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PutMapping
    public  ResponseEntity updateUser (@RequestBody @Valid UpdateUserDTO data){
        HttpResponses response = userUseCases.updateProduct(data);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @DeleteMapping
    public  ResponseEntity deleteUser(@RequestBody  DeleteUserDTO data){
        HttpResponses response = userUseCases.deleteUser(data);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
