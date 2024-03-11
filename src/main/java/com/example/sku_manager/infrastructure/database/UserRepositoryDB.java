package com.example.sku_manager.infrastructure.database;

import com.example.sku_manager.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryDB  extends JpaRepository<User, Integer> {
    User findByUsername(String name);
    User findByEmail(String email);
}
