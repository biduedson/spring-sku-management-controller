package com.example.sku_manager.application.usecases.user.userServiceImpl;

import com.example.sku_manager.application.dtos.usersDTOs.CreateUserUserDTO;
import com.example.sku_manager.application.usecases.user.userService.CreateUserService;
import com.example.sku_manager.domain.exceptions.userExceptions.EmailAlreadyUsedException;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.User;
import com.example.sku_manager.infrastructure.database.UserRepositoryDB;
import org.springframework.stereotype.Service;

@Service
public  class CreateUserServiceImpl implements CreateUserService {
    private  final UserRepositoryDB userRepositoryDB;
    private  final HttpResponses httpResponse;

    public CreateUserServiceImpl(UserRepositoryDB userRepositoryDB, HttpResponses httpResponse) {
        this.userRepositoryDB = userRepositoryDB;
        this.httpResponse = httpResponse;

    }
    @Override
    public HttpResponses createUser(CreateUserUserDTO data){

        if(userRepositoryDB.existsByUsername(data.username())){
            throw  new EmailAlreadyUsedException("O username já está sendo usado por outro usuario", 409);
        }

        if(userRepositoryDB.existsByEmail(data.email())){
          throw  new EmailAlreadyUsedException("O e-mail já está sendo usado por outro usuario", 409);
        }

        User user = new User(data.username(), data.email(), data.password(), data.accesslevel());
        userRepositoryDB.save(user);
        httpResponse.setStatusCode(200);
        httpResponse.setBody("usuario criado com sucesso.");
        return httpResponse;
    }
}
