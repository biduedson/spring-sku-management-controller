package com.example.sku_manager.config;

import com.example.sku_manager.application.dtos.UpdateUserDTO;
import com.example.sku_manager.application.usecases.UserUseCases;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.infrastructure.database.UserRepositoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Autowired
    private UserRepositoryDB userRepositoryDB;

    @Autowired
    private HttpResponses httpResponses;

    @Bean
    public static UserUseCases userUseCases(UserRepositoryDB userRepositoryDB, HttpResponses httpResponses){
        return new UserUseCases(userRepositoryDB, httpResponses);
    }

    @Bean
    public static HttpResponses httpResponses() {
        return new HttpResponses();
    }


}
