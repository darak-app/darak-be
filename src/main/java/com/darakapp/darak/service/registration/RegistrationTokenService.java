package com.darakapp.darak.service.registration;

import com.darakapp.darak.dto.request.registration.RegistrationRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class RegistrationTokenService {

    @Value("${spring.registration_jwt.secret}")
    private String secret;

    @Value("${spring.registration_jwt.expiration}")
    private long jwtExpirationMs;

    public String create(RegistrationRequest tokenRequest, String verificationCode) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + jwtExpirationMs);
        return Jwts.builder()
            .setSubject("registration")
            .setIssuedAt(now)
            .setExpiration(expiry)
            .claim("verification_code", verificationCode)
            .claim("username", tokenRequest.getUsername())
            .claim("gender", tokenRequest.getGender())
            .claim("nickname", tokenRequest.getNickname())
            .claim("password", tokenRequest.getPassword())
            .claim("email", tokenRequest.getEmail())
            .claim("phoneNumber", tokenRequest.getPhoneNumber())
            .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS512)
            .compact();
    }

    public RegistrationRequest validateAndParseToken(String token, String verificationCode) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            if (!(claims.getSubject().equals("registration")))
                return null;
            if ((claims.get("verification_code").equals(verificationCode)) &&
                (claims.containsKey("username")) &&
                (claims.containsKey("password")) &&
                (claims.containsKey("gender")) &&
                (claims.containsKey("nickname")) &&
                (claims.containsKey("email")) &&
                (claims.containsKey("phoneNumber"))
            ) {
                return RegistrationRequest.builder()
                        .username((String) claims.get("username"))
                        .password((String) claims.get("password"))
                        .gender((String) claims.get("gender"))
                        .nickname((String) claims.get("nickname"))
                        .email((String) claims.get("email"))
                        .phoneNumber((String) claims.get("phoneNumber"))
                        .build();
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
