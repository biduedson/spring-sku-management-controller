package com.example.sku_manager.application.usecases.user.userServiceImpl;

import com.example.sku_manager.application.dtos.usersDTOs.UpdateUserDTO;
import com.example.sku_manager.interfaces.views.UserView;
import com.example.sku_manager.application.usecases.user.userService.UpdateUserService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.User;
import com.example.sku_manager.infrastructure.database.UserRepositoryDB;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UpdateUserServiceImpl  implements UpdateUserService {
    private  final UserRepositoryDB userRepositoryDB;
    private  final HttpResponses httpResponse;

    public UpdateUserServiceImpl(UserRepositoryDB userRepositoryDB, HttpResponses httpResponse) {
        this.userRepositoryDB = userRepositoryDB;
        this.httpResponse = httpResponse;
    }

    @Override
    public HttpResponses updateUser(UpdateUserDTO data){

        Optional<User> userOptional = userRepositoryDB.findById(data.id());

        if (userOptional.isPresent()){
            User user = userOptional.get();
            boolean usernameExisting =  userRepositoryDB.existsByUsername(data.username())  && !user.getUsername().equals(data.username());
            boolean userEmailExisting = userRepositoryDB.existsByEmail(data.email())&&  !user.getEmail().equals(data.email());

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
            httpResponse.setBody("Usuario Atualizado com sucesso.");
            httpResponse.setBody(userUpdatedView);
        }else{
            httpResponse.setStatusCode(404);
            httpResponse.setBody("Usuario não encontrado.");
            return httpResponse;
        }
        return  httpResponse;
    }

}
