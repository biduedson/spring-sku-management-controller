package com.example.sku_manager.application.usecases.user.userService;

import com.example.sku_manager.application.interfaces.UserView;
import com.example.sku_manager.domain.HttpResponses;

import java.util.List;

public interface GetUserService {
   HttpResponses  getAllUsers();
}
