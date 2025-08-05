package com.darakapp.darak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TokenService {

    private final RedisTemplate<String, String> redisTemplate;

    // 화이트리스트 키 네임스페이스
    private static final String WHITELIST_KEY = "auth:whitelist";
    // 블랙리스트 키 네임스페이스
    private static final String BLACKLIST_KEY = "auth:blacklist";

    @Autowired
    public TokenService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // 화이트리스트에 토큰 추가 (예: 로그인 시)
    public void addToWhitelist(String token, long expireSeconds) {
        redisTemplate.opsForValue().set(WHITELIST_KEY + ":" + token, "valid", expireSeconds, TimeUnit.SECONDS);
    }

    // 화이트리스트 확인
    public boolean isWhitelisted(String token) {
        return redisTemplate.hasKey(WHITELIST_KEY + ":" + token);
    }

    // 블랙리스트에 토큰 추가 (예: 로그아웃 시)
    public void addToBlacklist(String token, long expireSeconds) {
        redisTemplate.opsForValue().set(BLACKLIST_KEY + ":" + token, "blocked", expireSeconds, TimeUnit.SECONDS);
    }

    // 블랙리스트 확인
    public boolean isBlacklisted(String token) {
        return redisTemplate.hasKey(BLACKLIST_KEY + ":" + token);
    }

    // 필요시 블랙리스트 / 화이트리스트에서 토큰 삭제 가능
    public void removeFromWhitelist(String token) {
        redisTemplate.delete(WHITELIST_KEY + ":" + token);
    }

    public void removeFromBlacklist(String token) {
        redisTemplate.delete(BLACKLIST_KEY + ":" + token);
    }
}
