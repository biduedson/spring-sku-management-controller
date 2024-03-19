package com.example.sku_manager.infrastructure.database;

import com.example.sku_manager.domain.AdvertisedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisedProductDB extends JpaRepository<AdvertisedProduct, Integer> {
    boolean existsByAdvertiseLink(String advertiseLink);
}
