package com.darakapp.darak.exception.api.common;


import com.darakapp.darak.exception.api.ApiException;
import com.darakapp.darak.exception.api.ApiExceptionDetails;

public class NoAccessApiException extends ApiException {
    public NoAccessApiException() {
        super(ApiExceptionDetails.ACCESS_DENIED);
    }
}
