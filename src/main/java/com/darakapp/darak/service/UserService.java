package com.darakapp.darak.service;

import com.darakapp.darak.domain.User;
import com.darakapp.darak.repository.UserRepository;
import com.darakapp.darak.util.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final TokenService tokenService;
    public UserService(UserRepository userRepository, JwtUtil jwtUtil, TokenService tokenService){
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.tokenService = tokenService;
    }

    public User


}
