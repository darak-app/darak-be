package com.darakapp.darak.domain;

import lombok.Data;

@Data
public class TokenValidationResponse {
    private boolean authenticated;
    private String message;

    public TokenValidationResponse(boolean authenticated, String message){
        this.authenticated = authenticated;
        this.message = message;
    }
    // 생성자, getter, setter
}