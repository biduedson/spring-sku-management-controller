package com.example.sku_manager.application.usecases.user.userService;

import com.example.sku_manager.application.dtos.usersDTOs.UpdateUserDTO;
import com.example.sku_manager.domain.HttpResponses;

public interface UpdateUserService {
    HttpResponses updateUser(UpdateUserDTO data);

}
