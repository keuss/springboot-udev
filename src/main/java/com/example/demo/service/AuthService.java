package com.example.demo.service;

import com.example.demo.pojo.AuthJSON;
import com.example.demo.pojo.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class AuthService {

    @Resource
    CacheManager cacheManager;

    public AuthResponse authenticate(AuthJSON authJSON) {
        // Do real authentication here ... with pwd ... (JSON Web Tokens for OAuth 2.0)

        // Create token
        String hashUserId = DigestUtils.md5Hex(authJSON.getUserId());
        this.authorize(hashUserId);

        // Response just for test
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAuthenticate(true);
        authResponse.setAuthorizeToken(hashUserId);
        return authResponse;
    }

    public void authorize(String hashUserId) {
        // Do real authorization here ...
        // Manage user info outside the app : in redis cache (horizontal scaling for the app !)
        if (hashUserId != null && !hashUserId.isEmpty() && cacheManager != null) {
            cacheManager.getCache("users").put("hashUserId", hashUserId);
        }
    }

    public boolean isAuthorize(String token) {
        if (token != null && !token.isEmpty() && cacheManager != null
                && cacheManager.getCache("users").get("hashUserId") != null) {
            String tokenInCache = (String) cacheManager.getCache("users").get("hashUserId").get();
            return tokenInCache != null && !tokenInCache.isEmpty() ? tokenInCache.equals(token) : false;
        }
        return false;
    }

}
