package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Slf4j
@Profile("!dev")
@EnableCaching
@Configuration
public class CacheConfiguration {

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        log.info("Call redisConnectionFactory ...");
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("myredis", 6379);
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public CacheManager redisCacheManager() {
        log.info("Call redisCacheManager ...");
        return RedisCacheManager.create(redisConnectionFactory());
    }
}
