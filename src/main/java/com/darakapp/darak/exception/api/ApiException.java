package com.darakapp.darak.exception.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiException extends RuntimeException {
    private String errorCode;
    private int httpStatusCode;
    private String errorMessage;

    public ApiException(ApiExceptionDetails details) {
        this.errorCode = details.getErrorCode();
        this.httpStatusCode = details.getHttpStatusCode();
        this.errorMessage = details.getMessage();
    }
}
