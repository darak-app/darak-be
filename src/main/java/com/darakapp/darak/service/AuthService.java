package com.darakapp.darak.service;

import com.darakapp.darak.domain.Role;
import com.darakapp.darak.domain.User;
import com.darakapp.darak.domain.enums.Gender;
import com.darakapp.darak.dto.request.SignupRequest;
import com.darakapp.darak.exception.api.common.NotFoundApiException;
import com.darakapp.darak.repository.UserRepository;
import com.darakapp.darak.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final long expired_time = 60*60*3; // 토큰 기본 지속시간, 3시간
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final TokenService tokenService;
    public AuthService(UserRepository userRepository, JwtUtil jwtUtil, TokenService tokenService){
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.tokenService = tokenService;
    }
    public void signup(SignupRequest request){
        // 아이디가 안겹치면
        if(userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("존재하는 유저입니다.");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setRole(Role.User);

        System.out.println(request.getUsername());
        userRepository.save(user);
    }
    public String login(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user == null) throw new NotFoundApiException();

        // 1. 비밀번호 검증 필요
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("비밀번호가 올바르지 않습니다.");
        }

        // 2. 인증 성공 시 JWT 토큰 생성
        String token = jwtUtil.generateToken(username);
        tokenService.addToWhitelist(token, expired_time);
        return token;
    }

    public boolean validateToken(String token){
        return jwtUtil.validateToken(token);
    }

}
