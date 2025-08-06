package com.darakapp.darak.service.registration;

import com.darakapp.darak.dto.request.registration.RegistrationRequest;
import com.darakapp.darak.entity.User;
import com.darakapp.darak.repository.jpa.UserRepository;
import com.darakapp.darak.service.authentication.UserService;
import com.darakapp.darak.service.registration.exception.RegistrationPhoneNumberVerificationFailureException;
import com.darakapp.darak.service.registration.exception.RegistrationUsernameVerificationFailureException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationValidationService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final RegistrationTokenService registrationTokenService;

    public PhoneNumberValidationResult validatePhoneNumber(String phoneNumber) {
        if (!userService.phoneNumberExists(phoneNumber)) {
            return PhoneNumberValidationResult.duplicate;
        }
        // TODO: 전화번호 제대로된 형식인지 검사
        return PhoneNumberValidationResult.ok;
    }

    public UsernameValidationResult validateUsername(String username) {
        Optional<User> foundUser = userRepository.findByUsername(username);
        if (foundUser.isPresent()) {
            return UsernameValidationResult.duplicate;
        }
        // TODO: 유저네임에 이상한 문자열 없는지 검사, 있으면 UsernameValidationResult.invalid 반환
        return UsernameValidationResult.ok;
    }

    public void validateTokenRequest(RegistrationRequest tokenRequest) {
        PhoneNumberValidationResult phoneNumberValidationResult = validatePhoneNumber(tokenRequest.getPhoneNumber());
        if (phoneNumberValidationResult != PhoneNumberValidationResult.ok) {
            throw new RegistrationPhoneNumberVerificationFailureException(phoneNumberValidationResult);
        }

        UsernameValidationResult usernameValidationResult = validateUsername(tokenRequest.getUsername());
        if (usernameValidationResult != UsernameValidationResult.ok) {
            throw new RegistrationUsernameVerificationFailureException(usernameValidationResult);
        }
    }

    public String createVerificationCode() {
        // TODO: 네이버 sens 구현은 나중에, 일단은 0000
        return "0000";
    }
}
