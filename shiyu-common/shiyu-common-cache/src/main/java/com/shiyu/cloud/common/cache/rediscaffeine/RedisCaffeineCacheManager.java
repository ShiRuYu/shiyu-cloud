package com.shiyu.cloud.common.cache.rediscaffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class RedisCaffeineCacheManager implements CacheManager {

    private final Logger logger = LoggerFactory.getLogger(RedisCaffeineCacheManager.class);


    private final RedisTemplate<Object, Object> redisTemplate;

    private final Map<String, Cache> cacheMap = new ConcurrentHashMap<>(16);

    private final Collection<String> cacheNames = new CopyOnWriteArrayList<>();

    public RedisCaffeineCacheManager(RedisTemplate<Object, Object> redisTemplate) {
        super();
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Cache getCache(@Nonnull String name) {
        Cache cache = cacheMap.get(name);
        if(cache != null) {
            return cache;
        }

        cache = new CacheRedisCaffeine(name, redisTemplate, caffeineCache());
        cacheNames.add(name);
        Cache oldCache = cacheMap.putIfAbsent(name, cache);
        logger.debug("create cache instance, the cache name is : {}", name);
        return oldCache == null ? cache : oldCache;
    }

    public com.github.benmanes.caffeine.cache.Cache<Object, Object> caffeineCache(){
        Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder();
        return cacheBuilder.build();
    }

    @Override
    @Nonnull
    public Collection<String> getCacheNames() {
        return this.cacheNames;
    }

    public void clearLocal(String cacheName, Object key) {
        Cache cache = cacheMap.get(cacheName);
        if(cache == null) {
            return ;
        }

        CacheRedisCaffeine redisCaffeineCache = (CacheRedisCaffeine) cache;
        redisCaffeineCache.clearLocal(key);
    }
}


