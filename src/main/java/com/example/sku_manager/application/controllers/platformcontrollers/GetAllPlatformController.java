package com.example.sku_manager.application.controllers.platformcontrollers;

import com.example.sku_manager.application.usecases.plaform.PlatformServices.GetAllPlatformService;
import com.example.sku_manager.domain.HttpResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
public class GetAllPlatformController {
    private final GetAllPlatformService getAllPlatformService;

    public GetAllPlatformController(GetAllPlatformService getAllPlatformService){
        this.getAllPlatformService = getAllPlatformService;
    }

    @GetMapping
    public ResponseEntity getAllPlatform(){
        HttpResponses responses = getAllPlatformService.allPlatform();
        return ResponseEntity.status(responses.getStatusCode()).body(responses.getBody());
    }
}
