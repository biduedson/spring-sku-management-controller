package com.example.sku_manager.application.usecases.user.userService;

import com.example.sku_manager.application.dtos.usersDTOs.CreateUserUserDTO;
import com.example.sku_manager.domain.HttpResponses;

public interface CreateUserService {
    HttpResponses createUser(CreateUserUserDTO userDTO);
}
