package com.example.sku_manager.application.controllers.userControllers;

import com.example.sku_manager.application.usecases.user.userService.GetUserService;
import com.example.sku_manager.domain.HttpResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class GetAllUsersController {


    private final  GetUserService getUserService;

    public GetAllUsersController(GetUserService getUserService){
        this.getUserService = getUserService;
    }
    @GetMapping
    public ResponseEntity allUsers(){
        HttpResponses response =  getUserService.getAllUsers();
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
