package com.darakapp.darak.exception.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiExceptionDetails {

    UNHANDLED(500, "global.internal_error", "서버 내부 오류입니다. 잠시 후 다시 시도해 주세요."),
    BAD_REQUEST(400, "global.bad_request", "잘못된 요청입니다."),
    ACCESS_DENIED(403, "global.unauthorized", "권한이 부족합니다."),
    NOT_FOUND(404, "global.not_found", "URL이 존재하지 않습니다."),

    // Sign Up
    SIGNUP_VALIDATION_ID_VERIFICATION_FAILURE(
            409,
            "signup.validation.id_verification_failure",
            "ID 중복확인이 완료되지 않았습니다."
    ),
    SIGNUP_VALIDATION_PHONE_NUMBER_VERIFICATION_FAILURE(
            409,
            "signup.validation.id_verification_failure",
            "ID 중복확인이 완료되지 않았습니다."
    ),
    SIGNUP_VALIDATION_TOKEN_VERIFICATION_FAILURE(
            409,
            "signup.validation.registration_token_verification_failure",
            "올바르지 않은 인증번호 입니다."
    );

    // Sign In

    private final int httpStatusCode;
    private final String errorCode;
    private final String message;
}
