package com.shiyu.cloud.common.cache;

import com.shiyu.cloud.common.cache.rediscaffeine.CacheRedisCaffeineManager;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.data.redis.cache.RedisCacheManager;

/**
 * Spring cache的一些配置，建议组件相关配置都放在相应的configuration类中
 */
@AutoConfiguration(after = {CaffeineCacheManager.class, RedisCacheManager.class, CacheRedisCaffeineManager.class})
public class CacheConfig extends CachingConfigurerSupport {
    @Resource
    private CacheRedisCaffeineManager cacheRedisCaffeineManager;

    /**
     * 重写这个方法，目的是用以提供默认的cacheManager
     * @return
     */
    @Override
    public CacheManager cacheManager() {
        return cacheRedisCaffeineManager;
    }

    /**
     * 如果cache出错， 记录在日志里，方便排查，比如反序列化异常
     */
    @Override
    public CacheErrorHandler errorHandler() {
        return new LoggingCacheErrorHandler();
    }

    class LoggingCacheErrorHandler extends SimpleCacheErrorHandler {
        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        @Override
        public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
            logger.error(String.format("cacheName:%s,cacheKey:%s",
                    cache == null ? "unknown" : cache.getName(), key), exception);
            super.handleCacheGetError(exception, cache, key);
        }

        @Override
        public void handleCachePutError(RuntimeException exception, Cache cache, Object key,
                                        Object value) {
            logger.error(String.format("cacheName:%s,cacheKey:%s",
                    cache == null ? "unknown" : cache.getName(), key), exception);
            super.handleCachePutError(exception, cache, key, value);
        }

        @Override
        public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
            logger.error(String.format("cacheName:%s,cacheKey:%s",
                    cache == null ? "unknown" : cache.getName(), key), exception);
            super.handleCacheEvictError(exception, cache, key);
        }

        @Override
        public void handleCacheClearError(RuntimeException exception, Cache cache) {
            logger.error(String.format("cacheName:%s", cache == null ? "unknown" : cache.getName()),
                    exception);
            super.handleCacheClearError(exception, cache);
        }
    }
}

