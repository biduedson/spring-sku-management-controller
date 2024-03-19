package com.example.sku_manager.application.controllers.platformcontrollers;

import com.example.sku_manager.application.dtos.platformDTOs.PlatformDTO;
import com.example.sku_manager.application.usecases.plaform.PlatformServices.CreatePlatformService;
import com.example.sku_manager.domain.HttpResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("platform")
public class CreatePlatformController {

    private final CreatePlatformService createPlatformService;

    public  CreatePlatformController(CreatePlatformService createPlatformService){
        this.createPlatformService = createPlatformService;
    }
    @PostMapping
    public ResponseEntity createPlatform(@RequestBody @Valid PlatformDTO data){
        HttpResponses response = createPlatformService.createPlatform(data);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
