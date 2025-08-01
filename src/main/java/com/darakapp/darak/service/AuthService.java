package com.darakapp.darak.service;

import com.darakapp.darak.domain.User;
import com.darakapp.darak.exception.api.common.NotFoundApiException;
import com.darakapp.darak.repository.UserRepository;
import com.darakapp.darak.util.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    public AuthService(UserRepository userRepository, JwtUtil jwtUtil){
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }
    public String login(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user == null)throw new NotFoundApiException();

        return jwtUtil.generateToken(username);
    }
}
