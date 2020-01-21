package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@SpringBootApplication(exclude = {RedisRepositoriesAutoConfiguration.class})
@PropertySource("classpath:myapp.properties")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        log.info("DemoApplication is running ...");
    }
}
