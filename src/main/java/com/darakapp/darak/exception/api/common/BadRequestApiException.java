package com.darakapp.darak.exception.api.common;


import com.darakapp.darak.exception.api.ApiException;
import com.darakapp.darak.exception.api.ApiExceptionDetails;

public class BadRequestApiException extends ApiException {
    public BadRequestApiException() {
        super(ApiExceptionDetails.BAD_REQUEST);
    }
}
