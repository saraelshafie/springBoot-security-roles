package com.vodafone.authorization.rolebasedcourse.DTO;

import lombok.Data;

@Data
public class AuthResponseDto {

    private final String jwt;


    public AuthResponseDto(String accessToken){
        this.jwt = accessToken;
    }
}
