package com.darakapp.darak.controller;

import com.darakapp.darak.service.AuthService;
import com.darakapp.darak.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<?> getUser(String token){
        return ResponseEntity.ok("ok");
    }
}
