package com.darakapp.darak.dto.response.registration;

import com.darakapp.darak.service.registration.UsernameValidationResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsernameValidationResponse {
    private UsernameValidationResult result;
}

