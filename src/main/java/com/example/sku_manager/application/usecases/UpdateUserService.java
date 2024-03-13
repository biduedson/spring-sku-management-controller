package com.example.sku_manager.application.usecases;

import com.example.sku_manager.application.dtos.UpdateUserDTO;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.User;

public interface UpdateUserService {
    HttpResponses updateUser(UpdateUserDTO data);

}
