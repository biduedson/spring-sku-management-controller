package com.example.sku_manager.infrastructure.database;

import com.example.sku_manager.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryDB extends JpaRepository<Product, Integer> {
}
