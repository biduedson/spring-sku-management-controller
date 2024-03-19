package com.example.sku_manager.application.usecases.user.userServiceImpl;

import com.example.sku_manager.application.dtos.usersDTOs.DeleteUserDTO;
import com.example.sku_manager.application.usecases.user.userService.DeleteUserService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.infrastructure.database.UserRepositoryDB;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserServiceImpl  implements DeleteUserService {

    private  final UserRepositoryDB userRepositoryDB;
    private final HttpResponses httpResponse;

    public  DeleteUserServiceImpl(UserRepositoryDB userRepositoryDB, HttpResponses httpResponse){
        this.userRepositoryDB = userRepositoryDB;
        this.httpResponse = httpResponse;
    }
    @Override
    public HttpResponses  deleteUser(DeleteUserDTO data){
        boolean userExisting = !userRepositoryDB.findById(data.id()).isPresent();
        HttpResponses response = new HttpResponses();
        if(!(data.id() instanceof Integer) ){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Id do usuario invalida ou ausente.");
            return httpResponse;
        }
        if(userExisting){
            httpResponse.setStatusCode(404);
            httpResponse.setBody("Usuario não encontrado");
            return httpResponse;
        }
        userRepositoryDB.deleteById(data.id());
        httpResponse.setStatusCode(200);
        httpResponse.setBody("Usuario deletado com sucesso.");
        return httpResponse;
    }
}
