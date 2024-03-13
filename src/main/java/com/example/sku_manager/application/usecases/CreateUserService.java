package com.example.sku_manager.application.usecases;

import com.example.sku_manager.application.dtos.CreateUserUserDTO;
import com.example.sku_manager.domain.HttpResponses;

public interface CreateUserService {
    HttpResponses createUser(CreateUserUserDTO userDTO);
}
