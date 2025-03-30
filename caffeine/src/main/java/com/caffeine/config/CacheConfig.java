package com.caffeine.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager () {
        SimpleCacheManager manager = new SimpleCacheManager();

        CaffeineCache memberCache = new CaffeineCache("memberCache", Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .maximumSize(100) // 초과시 오래된 항목 순서로 삭제됨
            .build());

        CaffeineCache orderCache = new CaffeineCache("orderCache", Caffeine.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .maximumSize(100)
            .build());

        manager.setCaches(Arrays.asList(memberCache, orderCache));
        return manager;
    }
}
