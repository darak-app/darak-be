package com.darakapp.darak.exception.api.handler;

import com.darakapp.darak.dto.response.ApiResponse;
import com.darakapp.darak.exception.api.ApiException;
import com.darakapp.darak.exception.api.common.NoAccessApiException;
import com.darakapp.darak.exception.api.common.NotFoundApiException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@RequiredArgsConstructor
public class BusinessApiExceptionHandler {
    private final HandlerUtil handlerUtil;

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneralApiException(ApiException e, HttpServletRequest request) {
        handlerUtil.log("general ApiException", e.toString(), request);
        return handlerUtil.buildResponseEntityWithApiException(e);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Void>> handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        handlerUtil.log("access denied", e.toString(), request);
        return handlerUtil.buildResponseEntityWithApiException(new NoAccessApiException());
    }

    @ExceptionHandler({
            NoResourceFoundException.class,
            NoHandlerFoundException.class
    })
    public ResponseEntity<ApiResponse<Void>> handleNotFoundExceptionClass(Exception e, HttpServletRequest request) {
        handlerUtil.log("not found", e.toString(), request);
        return handlerUtil.buildResponseEntityWithApiException(new NotFoundApiException());
    }
}
