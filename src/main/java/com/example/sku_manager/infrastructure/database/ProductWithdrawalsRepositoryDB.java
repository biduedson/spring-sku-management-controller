package com.example.sku_manager.infrastructure.database;

import com.example.sku_manager.domain.ProductWithdrawals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductWithdrawalsRepositoryDB extends JpaRepository<ProductWithdrawals,Integer> {

}
