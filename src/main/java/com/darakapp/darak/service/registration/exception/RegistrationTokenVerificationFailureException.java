package com.darakapp.darak.service.registration.exception;

import com.darakapp.darak.exception.api.ApiException;
import com.darakapp.darak.exception.api.ApiExceptionDetails;

public class RegistrationTokenVerificationFailureException extends ApiException {
    public RegistrationTokenVerificationFailureException() {
        super(ApiExceptionDetails.SIGNUP_VALIDATION_TOKEN_VERIFICATION_FAILURE);
    }
}
