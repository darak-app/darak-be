package com.darakapp.darak.controller;


import com.darakapp.darak.domain.TokenValidationResponse;
import com.darakapp.darak.dto.request.LoginRequest;
import com.darakapp.darak.dto.request.SignupRequest;
import com.darakapp.darak.service.AuthService;
import com.darakapp.darak.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request){
        System.out.println("signup");
        try{
            authService.signup(request);
            return ResponseEntity.ok("success");
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("fail");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        System.out.println("login");
        String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(token);
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LoginRequest loginRequest){
        String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(token);
    }
    @PostMapping("/validate-token")
    public ResponseEntity<?> validateToken(@RequestBody String token){
        boolean valid =  authService.validateToken(token);
        if(valid){
            return ResponseEntity.ok(new TokenValidationResponse(true, "Token is valid"));
        }
        else return ResponseEntity.ok(new TokenValidationResponse(false, "Token is not valid"));
    }
}
