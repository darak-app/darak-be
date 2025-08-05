package com.darakapp.darak.dto.request;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String name;
}

