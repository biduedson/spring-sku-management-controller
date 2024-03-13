package com.example.sku_manager.infrastructure.database;

import com.example.sku_manager.application.interfaces.UserView;
import com.example.sku_manager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryDB  extends JpaRepository<User, Integer> {
    List<UserView> findAllProjectedByOrderByIdAsc();

    UserView  findProjectedById(Integer id);
    User findByUsername(String name);
    User findByEmail(String email);
}
