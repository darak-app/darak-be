package com.darakapp.darak.service.registration.exception;

import com.darakapp.darak.exception.api.ApiException;
import com.darakapp.darak.exception.api.ApiExceptionDetails;
import com.darakapp.darak.service.registration.PhoneNumberValidationResult;

public class RegistrationPhoneNumberVerificationFailureException extends ApiException {
    public RegistrationPhoneNumberVerificationFailureException(PhoneNumberValidationResult validationResult) {
        super(ApiExceptionDetails.SIGNUP_VALIDATION_PHONE_NUMBER_VERIFICATION_FAILURE);
        setErrorMessage(getErrorMessage() + "\n" + validationResult.getMessage());
    }
}
