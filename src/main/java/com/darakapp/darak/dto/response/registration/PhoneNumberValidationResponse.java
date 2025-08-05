package com.darakapp.darak.dto.response.registration;

import com.darakapp.darak.service.registration.PhoneNumberValidationResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhoneNumberValidationResponse {
    private PhoneNumberValidationResult result;
}

