package com.example.sku_manager.application.usecases.user.userServiceImpl;

import com.example.sku_manager.application.dtos.usersDTOs.UpdateUserDTO;
import com.example.sku_manager.application.interfaces.UserView;
import com.example.sku_manager.application.usecases.user.userService.UpdateUserService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.User;
import com.example.sku_manager.infrastructure.database.UserRepositoryDB;

import java.util.Optional;

public class UpdateUserServiceImpl  implements UpdateUserService {
    private  final UserRepositoryDB userRepositoryDB;
    private  final HttpResponses httpResponse;

    public UpdateUserServiceImpl(UserRepositoryDB userRepositoryDB, HttpResponses httpResponse) {
        this.userRepositoryDB = userRepositoryDB;
        this.httpResponse = httpResponse;
    }

    @Override
    public HttpResponses updateUser(UpdateUserDTO data){
        boolean usernameExisting =  userRepositoryDB.findByUsername(data.username()) != null;
        boolean userEmailExisting =  userRepositoryDB.findByEmail(data.email()) != null;
        HttpResponses response = new HttpResponses();
        Optional<User> userOptional = userRepositoryDB.findById(data.id());


        if (userOptional.isPresent()){
            User user = userOptional.get();
            if( user.getUsername().equals(data.username()) || user.getEmail().equals(data.email()) ){
                httpResponse.setStatusCode(400);
                httpResponse.setBody(user.getUsername().equals(data.username()) ?
                                     "O novo username deve ser diferente do username atual":
                                     "O novo email  deve ser diferente do email atual");
                return httpResponse;
            }

            if(usernameExisting || userEmailExisting){
                httpResponse.setStatusCode(400);
                httpResponse.setBody(usernameExisting ?
                                    "Já existe  um usuario com este username cadastrado.":
                                    "Já existe  um usuario com este email cadastrado.");
                return httpResponse;
            }

            user.setUsername(data.username());
            user.setEmail(data.email());
            User userUpdated = userRepositoryDB.save(user);
            UserView userUpdatedView = userRepositoryDB.findProjectedById(data.id());
            httpResponse.setStatusCode(200);
            response.setBody("Usuario Atualizado com sucesso.");
            httpResponse.setBody(userUpdatedView);
        }else{
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Usuario não encontrado.");
            return httpResponse;
        }
        return  httpResponse;
    }

}
