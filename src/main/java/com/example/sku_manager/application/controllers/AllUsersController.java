package com.example.sku_manager.application.controllers;

import com.example.sku_manager.application.usecases.userServiceImpl.GetUserServiceImpl;
import com.example.sku_manager.domain.HttpResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AllUsersController {

    @Autowired
    GetUserServiceImpl getUserServiceImpl;

    @GetMapping
    public ResponseEntity allUsers(){
        HttpResponses response =  getUserServiceImpl.getAllUsers();
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
