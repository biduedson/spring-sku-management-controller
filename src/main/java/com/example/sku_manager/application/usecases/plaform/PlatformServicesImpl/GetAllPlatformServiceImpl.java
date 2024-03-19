package com.example.sku_manager.application.usecases.plaform.PlatformServicesImpl;

import com.example.sku_manager.application.usecases.plaform.PlatformServices.GetAllPlatformService;
import com.example.sku_manager.domain.HttpResponses;
import com.example.sku_manager.domain.Platform;
import com.example.sku_manager.infrastructure.database.PlatformRepositoryDB;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetAllPlatformServiceImpl implements GetAllPlatformService {
    private  final PlatformRepositoryDB platformRepositoryDB;
    private final HttpResponses httpResponses;

    public  GetAllPlatformServiceImpl(PlatformRepositoryDB platformRepositoryDB,HttpResponses httpResponses){
        this.platformRepositoryDB = platformRepositoryDB;
        this.httpResponses = httpResponses;
    }
    @Override
    public HttpResponses allPlatform(){
       List<Platform> platforms = platformRepositoryDB.findAll();
       httpResponses.setStatusCode(200);
       httpResponses.setBody(platforms);
       return  httpResponses;
    }
}
