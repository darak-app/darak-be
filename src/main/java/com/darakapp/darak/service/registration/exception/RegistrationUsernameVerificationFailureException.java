package com.darakapp.darak.service.registration.exception;

import com.darakapp.darak.exception.api.ApiException;
import com.darakapp.darak.exception.api.ApiExceptionDetails;
import com.darakapp.darak.service.registration.UsernameValidationResult;

public class RegistrationUsernameVerificationFailureException extends ApiException {
    public RegistrationUsernameVerificationFailureException(UsernameValidationResult validationResult) {
        super(ApiExceptionDetails.SIGNUP_VALIDATION_TOKEN_VERIFICATION_FAILURE);
        setErrorMessage(getErrorMessage() + "\n" + validationResult.getMessage());
    }
}
