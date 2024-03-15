package com.example.sku_manager.application.dtos.usersDTOs;

import jakarta.validation.constraints.NotBlank;


public record CreateUserUserDTO(

        Integer id,
        @NotBlank
        String username,

        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotBlank
        String accesslevel
){

}
