package com.example.sku_manager.application.controllers.userControllers;

import com.example.sku_manager.application.dtos.usersDTOs.CreateUserUserDTO;
import com.example.sku_manager.application.usecases.user.userService.CreateUserService;
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
    private CreateUserService createUserService;
    @PostMapping
    public ResponseEntity newUser(@RequestBody @Valid CreateUserUserDTO data){
        HttpResponses response = createUserService.createUser(data);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
