package com.darakapp.darak.exception.api.common;


import com.darakapp.darak.exception.api.ApiException;
import com.darakapp.darak.exception.api.ApiExceptionDetails;

public class NotFoundApiException extends ApiException {
    public NotFoundApiException() {
        super(ApiExceptionDetails.NOT_FOUND);
    }
}
