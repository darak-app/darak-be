package com.darakapp.darak.dto.response;

import com.darakapp.darak.dto.response.registration.TokenResponse;
import com.darakapp.darak.exception.api.ApiException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    private final int status;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String errorCode;

    public static ApiResponse<Void> success(HttpStatus status) {
        return new ApiResponse<>(status.value(), "요청이 성공적으로 처리되었습니다.", null, null);
    }
    public static ApiResponse<Void> success(HttpStatus status, String message) {
       return new ApiResponse<>(status.value(), message, null, null);
    }
    public static <DataType> ApiResponse<DataType> success(HttpStatus status, DataType data) {
        return new ApiResponse<>(status.value(), "요청이 성공적으로 처리되었습니다.", data, null);
    }
    public static ApiResponse<Void> failureWithApiException(ApiException e) {
        return new ApiResponse<>(e.getHttpStatusCode(), e.getErrorMessage(), null, e.getErrorCode());
    }
    public static <DataType> ApiResponse<DataType> failure(HttpStatus status, String message, DataType data) {
        return new ApiResponse<>(status.value(), message, data, null);
    }
}
