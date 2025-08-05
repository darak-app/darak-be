package com.darakapp.darak.dto.request.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegistrationTokenValidationRequest {
    private String smsVerificationCode;
}
