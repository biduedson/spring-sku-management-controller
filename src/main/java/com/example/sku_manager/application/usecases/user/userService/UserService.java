package com.example.sku_manager.application.usecases.user.userService;

import com.example.sku_manager.application.interfaces.UserView;
import com.example.sku_manager.domain.User;

import java.util.List;

public interface UserService {
    List<UserView> getAllUsers();
    User getUserById(Integer id);

    User updateUser(Integer id);
    void deleteUser(Integer id);
}
