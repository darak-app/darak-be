package com.darakapp.darak.dto.request.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsernameValidationRequest {
    private String usernameToValidate;
}
