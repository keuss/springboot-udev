package com.example.demo.service;

import com.example.demo.pojo.AuthJSON;
import com.example.demo.pojo.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthService {

    public AuthResponse authenticate(AuthJSON authJSON) {
        // Do real authentication here ... with pwd ... (JSON Web Tokens for OAuth 2.0)

        // Create token
        String hashUserId = DigestUtils.md5Hex(authJSON.getUserId());

        // Response
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAuthenticate(true);
        authResponse.setAuthorize(this.authorize(hashUserId));
        authResponse.setAppToken(hashUserId);
        return authResponse;
    }

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "users", key = "#appToken")
    public boolean authorize(String appToken) {
        log.info("Called authorize ...");
        // Do real authorization here ...
        // Manage user info outside the app : in redis cache (horizontal scaling for the app !)
        return appToken != null && !appToken.isBlank() ? true : false;
    }
}
