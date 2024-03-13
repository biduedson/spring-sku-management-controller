package com.example.sku_manager.application.usecases.userServiceImpl;

import com.example.sku_manager.application.dtos.UpdateUserDTO;
import com.example.sku_manager.application.interfaces.UserView;
import com.example.sku_manager.application.usecases.UpdateUserService;
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

System.out.println(data.id());
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if( user.getUsername().equals(data.username()) ){
                httpResponse.setStatusCode(400);
                httpResponse.setBody("O novo username deve ser diferente do username atual");
                return httpResponse;
            }
            if(user.getEmail().equals(data.email()) ){
                httpResponse.setStatusCode(400);
                httpResponse.setBody("O novo email  deve ser diferente do email atual");
                return httpResponse;
            }

            if(usernameExisting ){
                httpResponse.setStatusCode(400);
                httpResponse.setBody("Já existe  um usuario com este username cadastrado.");
                return httpResponse;
            }

            if(userEmailExisting){
                httpResponse.setStatusCode(400);
                httpResponse.setBody("Já existe  um usuario com este email cadastrado.");
                return httpResponse;
            }

            response.setBody("Usuario Atualizado com sucesso.");
            user.setUsername(data.username());
            user.setEmail(data.email());
            httpResponse.setStatusCode(200);
            User userUpdated = userRepositoryDB.save(user);
            UserView userUpdatedView = userRepositoryDB.findProjectedById(data.id());
            httpResponse.setBody(userUpdatedView);
        }else{
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Usuario não encontrado.");
            return httpResponse;
        }
        return  httpResponse;
    }

    public boolean emailExisting(String email){
        User user =  userRepositoryDB.findByEmail(email);
        return user != null;
    }

    public boolean userExisting(Integer id){
        Optional<User> user = userRepositoryDB.findById(id);
        return user.get() != null;
    }
}
