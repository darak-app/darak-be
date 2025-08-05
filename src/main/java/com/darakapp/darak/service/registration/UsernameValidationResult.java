package com.darakapp.darak.service.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UsernameValidationResult {
    ok("사용 가능한 ID 입니다."),
    invalid("잘못된 ID 입니다."),
    duplicate("이미 가입된 ID 입니다.");

    private final String message;
}
