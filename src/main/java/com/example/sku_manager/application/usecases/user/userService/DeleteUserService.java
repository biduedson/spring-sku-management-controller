package com.example.sku_manager.application.usecases.user.userService;

import com.example.sku_manager.application.dtos.usersDTOs.DeleteUserDTO;
import com.example.sku_manager.domain.HttpResponses;

public interface DeleteUserService {
    HttpResponses deleteUser(DeleteUserDTO data);
}
