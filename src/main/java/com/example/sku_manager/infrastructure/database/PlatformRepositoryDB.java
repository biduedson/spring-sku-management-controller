package com.example.sku_manager.infrastructure.database;

import com.example.sku_manager.domain.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepositoryDB extends JpaRepository<Platform, Integer> {
    boolean existsByName(String platform_name);
    boolean existsByImgurl(String imgurl);
}
