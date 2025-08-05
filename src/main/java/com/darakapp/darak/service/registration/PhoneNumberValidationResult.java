package com.darakapp.darak.service.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneNumberValidationResult {
    ok("사용 가능한 전화번호 입니다."),
    invalid("존재하지 않는 전화번호 입니다."),
    duplicate("이미 가입된 전화번호 입니다.");

    private final String message;
}
