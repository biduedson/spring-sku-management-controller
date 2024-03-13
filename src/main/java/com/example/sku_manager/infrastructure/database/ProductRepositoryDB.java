package com.example.sku_manager.infrastructure.database;

import com.example.sku_manager.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryDB extends JpaRepository<Product, Integer> {
    Product findByName(String name);
    Product findBySku(String sku);
    Product findByImgurl(String imgurl);
    Product findByGtin(String gtin);


}
