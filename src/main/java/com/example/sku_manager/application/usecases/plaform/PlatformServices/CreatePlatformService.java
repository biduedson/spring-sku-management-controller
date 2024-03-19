package com.example.sku_manager.application.usecases.plaform.PlatformServices;

import com.example.sku_manager.application.dtos.platformDTOs.PlatformDTO;
import com.example.sku_manager.domain.HttpResponses;

public interface CreatePlatformService {
    HttpResponses createPlatform(PlatformDTO data);
}
