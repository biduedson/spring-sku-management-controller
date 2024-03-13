package com.example.sku_manager.config;

import com.example.sku_manager.application.usecases.userServiceImpl.DeleteUserServiceImpl;
import com.example.sku_manager.application.usecases.userServiceImpl.GetUserServiceImpl;
import com.example.sku_manager.application.usecases.userServiceImpl.CreateUserServiceImpl;
import com.example.sku_manager.application.usecases.UserUseCases;
import com.example.sku_manager.application.usecases.userServiceImpl.UpdateUserServiceImpl;
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
    public static HttpResponses httpResponses() {
        return new HttpResponses();
    }

    @Bean
    public static CreateUserServiceImpl createUserService(UserRepositoryDB userRepositoryDB, HttpResponses httpResponses) {
        return new CreateUserServiceImpl(userRepositoryDB, httpResponses);
    }

    @Bean
    public static GetUserServiceImpl getUserServiceImpl(UserRepositoryDB userRepositoryDB, HttpResponses httpResponses) {
        return new GetUserServiceImpl(userRepositoryDB, httpResponses);
    }

    @Bean
    public static UpdateUserServiceImpl updateUserServiceImpl(UserRepositoryDB userRepositoryDB, HttpResponses httpResponses) {
        return new UpdateUserServiceImpl(userRepositoryDB, httpResponses);
    }

    @Bean
    public static DeleteUserServiceImpl deleteUserServiceImpl(UserRepositoryDB userRepositoryDB, HttpResponses httpResponses) {
        return new DeleteUserServiceImpl(userRepositoryDB, httpResponses);
    }
}