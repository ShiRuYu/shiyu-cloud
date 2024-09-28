package com.shiyu.cloud.common.cache.rediscaffeine;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;

/**
 * Spring cache的一些配置，建议组件相关配置都放在相应的configuration类中
 */
@RequiredArgsConstructor
public class ShiYuRedisCaffeineCacheConfig implements CachingConfigurer {

    private final RedisCaffeineCacheManager redisCaffeineCacheManager;

    /**
     * 重写这个方法，目的是用以提供默认的cacheManager
     */
    @Override
    public CacheManager cacheManager() {
        return redisCaffeineCacheManager;
    }

    /**
     * 如果cache出错， 记录在日志里，方便排查，比如反序列化异常
     */
    @Override
    public CacheErrorHandler errorHandler() {
        return new LoggingCacheErrorHandler();
    }

    static class LoggingCacheErrorHandler extends SimpleCacheErrorHandler {
        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        @Override
        public void handleCacheGetError(@Nonnull RuntimeException exception, Cache cache,@Nonnull Object key) {
            logger.error(String.format("cacheName:%s,cacheKey:%s",
                    cache.getName(), key), exception);
            super.handleCacheGetError(exception, cache, key);
        }

        @Override
        public void handleCachePutError(@Nonnull RuntimeException exception, Cache cache,@Nonnull Object key,
                                        Object value) {
            logger.error(String.format("cacheName:%s,cacheKey:%s",
                    cache.getName(), key), exception);
            super.handleCachePutError(exception, cache, key, value);
        }

        @Override
        public void handleCacheEvictError(@Nonnull RuntimeException exception, Cache cache,@Nonnull Object key) {
            logger.error(String.format("cacheName:%s,cacheKey:%s",
                    cache.getName(), key), exception);
            super.handleCacheEvictError(exception, cache, key);
        }

        @Override
        public void handleCacheClearError(@Nonnull RuntimeException exception, Cache cache) {
            logger.error(String.format("cacheName:%s", cache.getName()),
                    exception);
            super.handleCacheClearError(exception, cache);
        }
    }
}

