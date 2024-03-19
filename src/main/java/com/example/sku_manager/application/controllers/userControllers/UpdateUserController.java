package com.example.sku_manager.application.controllers.userControllers;

import com.example.sku_manager.application.dtos.usersDTOs.UpdateUserDTO;
import com.example.sku_manager.application.usecases.user.userService.UpdateUserService;
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

    private final UpdateUserService updateUserService;

    public UpdateUserController(UpdateUserService updateUserService){
        this.updateUserService = updateUserService;
    }
    @PutMapping
    public ResponseEntity updateUser(@RequestBody @Valid UpdateUserDTO data){
        HttpResponses response = updateUserService.updateUser(data);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());

    }
}
