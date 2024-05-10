package com.shiyu.cloud.common.cache.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.shiyu.cloud.common.cache.CacheConstants;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@AutoConfiguration
@EnableCaching
public class CacheCaffeineConfig {

    /**
     * 创建基于Caffeine的Cache Manager
     * @return
     */
    @Bean
    public CaffeineCacheManager cacheCaffeineManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        Cache<Object, Object> build = Caffeine.newBuilder().recordStats()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .maximumSize(10000)
                .build();
        caffeineCacheManager.registerCustomCache(CacheConstants.SERVER_CACHE,build);
        return caffeineCacheManager;
    }

}

