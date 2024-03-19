package com.example.sku_manager.application.controllers.userControllers;

import com.example.sku_manager.application.dtos.usersDTOs.DeleteUserDTO;
import com.example.sku_manager.application.usecases.user.userService.DeleteUserService;
import com.example.sku_manager.domain.HttpResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DeleteUserController {

    private final DeleteUserService deleteUserService;

    public DeleteUserController(DeleteUserService deleteUserService){
        this.deleteUserService = deleteUserService;
    }
@DeleteMapping
    public ResponseEntity DeleteUserServiceImpl(@RequestBody  DeleteUserDTO data){
        HttpResponses responses = deleteUserService.deleteUser(data);
        return  ResponseEntity.status(responses.getStatusCode()).body(responses.getBody());
    }
}
