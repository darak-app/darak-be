package com.darakapp.darak.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // 비밀키 (서명용) - 충분히 길고 복잡하게 설정
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // 토큰 만료 시간 (예: 1시간)
    private final long expiration = 1000 * 60 * 60;

    // 토큰 생성
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(username)             // 토큰 주체
                .setIssuedAt(now)                 // 발급 시간
                .setExpiration(expiryDate)        // 만료 시간
                .signWith(key)                   // 서명
                .compact();
    }

    // 토큰에서 username 추출
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 토큰 유효성 검사
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
