package com.example.sku_manager.application.usecases;

import com.example.sku_manager.application.dtos.CreateUserUserDTO;
import com.example.sku_manager.application.dtos.DeleteUserDTO;
import com.example.sku_manager.application.dtos.UpdateUserDTO;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.user.User;
import com.example.sku_manager.infrastructure.database.UserRepositoryDB;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class UserUseCases {
    private  final UserRepositoryDB userRepositoryDB;
    private  final  HttpResponses httpResponse;

    public UserUseCases(UserRepositoryDB userRepositoryDB, HttpResponses httpResponse){
        this.userRepositoryDB = userRepositoryDB;
        this.httpResponse = httpResponse;
    }



    public HttpResponses newUser(CreateUserUserDTO userDTO){
       // HttpResponses response = new HttpResponses();

        if(usernameExisting(userDTO.username())){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Já existe  um usuario com este username cadastrado.");
            return httpResponse;
        }
        if(emailExisting(userDTO.email())){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Já existe  um usuario com este email cadastrado.");
            return httpResponse;
        }
        User user = new User(userDTO.username(), userDTO.email(), userDTO.password(), userDTO.accesslevel());
        userRepositoryDB.save(user);
        httpResponse.setStatusCode(201);
        httpResponse.setBody(user);
        return httpResponse;
    }
    public HttpResponses allUsers(){
        List<User> allUser = userRepositoryDB.findAll();
        httpResponse.setStatusCode(200);
           httpResponse.setBody(allUser.stream()
                   .sorted(Comparator.comparing(User::getId))
                   .collect(Collectors.toList()));
           return  httpResponse;
    }


    public HttpResponses updateProduct(UpdateUserDTO data){
        HttpResponses response = new HttpResponses();
        Optional<User> userOptional = userRepositoryDB.findById(data.id());

        if (userOptional.isPresent()){
            User user = userOptional.get();
            if( user.getUsername().equals(data.username()) ){
                httpResponse.setStatusCode(400);
                httpResponse.setBody("O novo username deve ser diferente do username atual");
                return httpResponse;
            }

            if(usernameExisting(data.username()) ){
                httpResponse.setStatusCode(400);
                httpResponse.setBody("Já existe  um usuario com este username cadastrado.");
                return httpResponse;
            }

            if(user.getEmail().equals(data.email()) ){
                httpResponse.setStatusCode(400);
                httpResponse.setBody("O novo email  deve ser diferente do email atual");
                return httpResponse;
            }

            if(emailExisting(data.email())){
                httpResponse.setStatusCode(400);
                httpResponse.setBody("Já existe  um usuario com este email cadastrado.");
                return httpResponse;
            }

            response.setBody("Usuario Atualizado com sucesso.");
            user.setUsername(data.username());
            user.setEmail(data.email());
            httpResponse.setStatusCode(200);
            User userUpdated = userRepositoryDB.save(user);
            httpResponse.setBody(data);
        }else{
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Este usuario não existe");
            return httpResponse;
        }
        return  httpResponse;
    }

    public HttpResponses deleteUser(DeleteUserDTO data){
        HttpResponses response = new HttpResponses();
        if(data.id() instanceof Integer ){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Id do usuario invalida ou ausente.");
            return httpResponse;
        }
        if(!userExisting(data.id())){
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Este usuario não existe");
            return httpResponse;
        }
        userRepositoryDB.deleteById(data.id());
        httpResponse.setStatusCode(200);
        httpResponse.setBody("Usuario deletado com sucesso.");
        return httpResponse;
    }

    public  Optional<User> userById(Integer id){
        return userRepositoryDB.findById(id);
    }
    public boolean usernameExisting(String name){
      User user =  userRepositoryDB.findByUsername(name);
      return user != null;
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
