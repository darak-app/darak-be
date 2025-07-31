package com.darakapp.darak.exception.api.common;


import com.darakapp.darak.exception.api.ApiException;
import com.darakapp.darak.exception.api.ApiExceptionDetails;

public class UnhandledApiException extends ApiException {
    public UnhandledApiException() {
       super(ApiExceptionDetails.UNHANDLED);
    }
}
