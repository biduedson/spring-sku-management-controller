package com.example.sku_manager.config;

import com.example.sku_manager.domain.HttpResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpResponseConfig {


    @Autowired
    private HttpResponses httpResponses;



    @Bean
    public static HttpResponses httpResponses() {
        return new HttpResponses();
    }
}



