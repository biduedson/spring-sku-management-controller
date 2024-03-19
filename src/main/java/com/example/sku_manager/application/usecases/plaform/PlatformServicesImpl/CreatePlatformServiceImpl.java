package com.example.sku_manager.application.usecases.plaform.PlatformServicesImpl;

import com.example.sku_manager.application.dtos.platformDTOs.PlatformDTO;
import com.example.sku_manager.application.usecases.plaform.PlatformServices.CreatePlatformService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Platform;
import com.example.sku_manager.domain.exceptions.platform.AlreadyUsedException;
import com.example.sku_manager.infrastructure.database.PlatformRepositoryDB;
import org.springframework.stereotype.Service;

@Service
public class CreatePlatformServiceImpl implements CreatePlatformService {
    private final PlatformRepositoryDB platformRepositoryDB;
    private  final HttpResponses httpResponses;

    public CreatePlatformServiceImpl(PlatformRepositoryDB platformRepositoryDB, HttpResponses httpResponses){
        this.platformRepositoryDB = platformRepositoryDB;
        this.httpResponses = httpResponses;
    }

    @Override
    public HttpResponses createPlatform(PlatformDTO data){
       boolean checkNameExistsByName = platformRepositoryDB.existsByName(data.name());
       boolean checkImgurlExistsByName = platformRepositoryDB.existsByImgurl(data.imgurl());

       if(checkNameExistsByName){
           throw  new AlreadyUsedException("Este nome de plataforma já está sendo usado", 409);
       }

       if(checkImgurlExistsByName){
            throw  new AlreadyUsedException("Esta Url já está sendo usada", 409);
        }
        Platform newPlatform = new Platform(data.id(), data.name(), data.imgurl());
        platformRepositoryDB.save(newPlatform);
        httpResponses.setStatusCode(201);
        httpResponses.setBody(newPlatform);
        return httpResponses;
    }
}
