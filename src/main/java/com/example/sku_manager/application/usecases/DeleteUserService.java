package com.example.sku_manager.application.usecases;

import com.example.sku_manager.application.dtos.DeleteUserDTO;
import com.example.sku_manager.domain.HttpResponses;

public interface DeleteUserService {
    HttpResponses deleteUser(DeleteUserDTO data);
}
