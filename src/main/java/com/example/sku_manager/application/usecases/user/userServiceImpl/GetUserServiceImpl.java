package com.example.sku_manager.application.usecases.user.userServiceImpl;

import com.example.sku_manager.application.interfaces.UserView;
import com.example.sku_manager.application.usecases.user.userService.GetUserService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.infrastructure.database.UserRepositoryDB;

import java.util.List;

public class GetUserServiceImpl implements GetUserService {
    private  final UserRepositoryDB userRepositoryDB;
    private  final HttpResponses httpResponse;

    public GetUserServiceImpl(UserRepositoryDB userRepositoryDB, HttpResponses httpResponse) {
        this.userRepositoryDB = userRepositoryDB;
        this.httpResponse = httpResponse;
    }
        @Override
        public  HttpResponses getAllUsers(){
        List<UserView> users = userRepositoryDB.findAllProjectedByOrderByIdAsc();
        httpResponse.setStatusCode(200);
        httpResponse.setBody(users);
        return  httpResponse;
    }
}
