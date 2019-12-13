package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Profile("dev")
@EnableCaching
@Configuration
public class CacheConfigurationDev {

    @Bean
    public CacheManager redisCacheManager() {
        // A basic, no operation CacheManager implementation suitable for disabling caching, typically used for
        // backing cache declarations without an actual backing store.
        log.info("Call redisCacheManager ...");
        return new NoOpCacheManager();
    }
}
