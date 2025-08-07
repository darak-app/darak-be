package com.darakapp.darak.service.authentication;

import com.darakapp.darak.dto.request.registration.RegistrationRequest;
import com.darakapp.darak.entity.User;
import com.darakapp.darak.entity.UserGender;
import com.darakapp.darak.repository.jpa.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(RegistrationRequest request) {
        userRepository.save(User.builder()
            .username(request.getUsername())
            .passwordHash(passwordEncoder.encode(request.getPassword()))
            .phoneNumberHash(passwordEncoder.encode(request.getPhoneNumber()))
            .nickname(request.getNickname())
            .email(request.getEmail())
            .gender(UserGender.valueOf(request.getGender()))
        .build());
    }
}
