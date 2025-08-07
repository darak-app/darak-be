package com.darakapp.darak.controller;

import com.darakapp.darak.dto.request.registration.PhoneNumberValidationRequest;
import com.darakapp.darak.dto.request.registration.RegistrationTokenValidationRequest;
import com.darakapp.darak.dto.request.registration.RegistrationRequest;
import com.darakapp.darak.dto.request.registration.UsernameValidationRequest;
import com.darakapp.darak.dto.response.ApiResponse;
import com.darakapp.darak.dto.response.registration.*;
import com.darakapp.darak.exception.api.common.UnhandledApiException;
import com.darakapp.darak.service.authentication.AuthenticationService;
import com.darakapp.darak.service.registration.PhoneNumberValidationResult;
import com.darakapp.darak.service.registration.RegistrationValidationService;
import com.darakapp.darak.service.registration.RegistrationTokenService;
import com.darakapp.darak.service.registration.UsernameValidationResult;
import com.darakapp.darak.service.registration.exception.RegistrationTokenVerificationFailureException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationValidationService registrationValidationService;
    private final RegistrationTokenService registrationTokenService;
    private final AuthenticationService authenticationService;

    @PostMapping("/username_validation")
    public ApiResponse<UsernameValidationResponse> validateUserName(
        @RequestBody UsernameValidationRequest request
    ) {
       UsernameValidationResult result =
               registrationValidationService.validateUsername(request.getUsernameToValidate());
       if (result == UsernameValidationResult.ok) {
           return ApiResponse.success(HttpStatus.OK, new UsernameValidationResponse(result));
       } else if (result == UsernameValidationResult.invalid) {
           return ApiResponse.failure(
                   HttpStatus.BAD_REQUEST,
                   result.getMessage(),
                   new UsernameValidationResponse(result));
       } else if (result == UsernameValidationResult.duplicate) {
           return ApiResponse.failure(
                   HttpStatus.CONFLICT,
                   result.getMessage(),
                   new UsernameValidationResponse(result));
       } else {
           throw new UnhandledApiException();
       }
    }

    @PostMapping("/phone_number_validation")
    public ApiResponse<PhoneNumberValidationResponse> validatePhoneNumber(
            @RequestBody PhoneNumberValidationRequest request
    ) {
        PhoneNumberValidationResult result =
                registrationValidationService.validatePhoneNumber(request.getPhoneNumberToValidate());
        if (result == PhoneNumberValidationResult.ok) {
            return ApiResponse.success(HttpStatus.OK, new PhoneNumberValidationResponse(result));
        } else if (result == PhoneNumberValidationResult.invalid) {
            return ApiResponse.failure(
                    HttpStatus.BAD_REQUEST,
                    result.getMessage(),
                    new PhoneNumberValidationResponse(result));
        } else if (result == PhoneNumberValidationResult.duplicate) {
            return ApiResponse.failure(
                    HttpStatus.CONFLICT,
                    result.getMessage(),
                    new PhoneNumberValidationResponse(result));
        } else {
            throw new UnhandledApiException();
        }
    }

    @PostMapping("/token")
    public ApiResponse<RegistrationResponse> createRegistrationToken(
            @RequestBody RegistrationRequest request
    ) {
        registrationValidationService.validateTokenRequest(request);
        String token = registrationTokenService.create(request, registrationValidationService.createVerificationCode());
        return ApiResponse.success(HttpStatus.CREATED, new RegistrationResponse(token));
    }

    @PostMapping("/registration_token_validation")
    public ApiResponse<Void> validateRegistrationToken(
            @RequestHeader("Registration-Token") String token,
            @RequestBody RegistrationTokenValidationRequest request
    ) {
        RegistrationRequest originalRequest
            = registrationTokenService.validateAndParseToken(token, request.getSmsVerificationCode());
       if (originalRequest != null) {
          authenticationService.createUser(originalRequest);
          return ApiResponse.success(HttpStatus.NO_CONTENT, null);
       } else {
           throw new RegistrationTokenVerificationFailureException();
       }

    }
}
