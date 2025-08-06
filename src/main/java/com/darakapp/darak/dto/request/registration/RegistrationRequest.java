package com.darakapp.darak.dto.request.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RegistrationRequest {
    private String username;
    private String nickname;
    private String gender;
    private String password;
    private String email;
    private String phoneNumber;
}
