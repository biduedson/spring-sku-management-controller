package com.example.sku_manager.application.usecases.userServiceImpl;

import com.example.sku_manager.application.dtos.CreateUserUserDTO;
import com.example.sku_manager.application.interfaces.UserView;
import com.example.sku_manager.application.usecases.CreateUserService;
import com.example.sku_manager.application.usecases.UserService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.User;
import com.example.sku_manager.infrastructure.database.UserRepositoryDB;

public  class CreateUserServiceImpl implements CreateUserService {
    private  final UserRepositoryDB userRepositoryDB;
    private  final HttpResponses httpResponse;

    public CreateUserServiceImpl(UserRepositoryDB userRepositoryDB, HttpResponses httpResponse) {
        this.userRepositoryDB = userRepositoryDB;
        this.httpResponse = httpResponse;

    }
    @Override
    public HttpResponses createUser(CreateUserUserDTO data){
        boolean usernameExisting =  userRepositoryDB.findByUsername(data.username()) != null;
        boolean userEmailExisting =  userRepositoryDB.findByEmail(data.email()) != null;

        if(usernameExisting || userEmailExisting){
            httpResponse.setStatusCode(400);
            if(usernameExisting){
                httpResponse.setBody("Já existe  um usuario com este username cadastrado.");
                return httpResponse;
            }
            if(userEmailExisting){
                httpResponse.setBody("Já existe  um usuario com este email cadastrado.");
                return httpResponse;
            }
            return httpResponse;
        }

        User user = new User(data.username(), data.email(), data.password(), data.accesslevel());
        userRepositoryDB.save(user);
        httpResponse.setStatusCode(201);
        UserView userCreateView = userRepositoryDB.findProjectedById(user.getId());
        httpResponse.setBody(userCreateView);
        return httpResponse;
    }
}
