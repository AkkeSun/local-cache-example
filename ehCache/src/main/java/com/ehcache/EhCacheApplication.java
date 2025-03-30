package com.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class EhCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhCacheApplication.class, args);
    }

}
