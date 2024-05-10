package com.shiyu.cloud.common.cache.rediscaffeine;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import com.github.benmanes.caffeine.cache.Caffeine;

public class CacheRedisCaffeineManager implements CacheManager {

    private final Logger logger = LoggerFactory.getLogger(CacheRedisCaffeineManager.class);

    private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();

    private RedisTemplate<Object, Object> redisTemplate;

    private boolean dynamic = true;

    private Set<String> cacheNames;

    public CacheRedisCaffeineManager(RedisTemplate<Object, Object> redisTemplate) {
        super();
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Cache getCache(String name) {
        Cache cache = cacheMap.get(name);
        if(cache != null) {
            return cache;
        }
        if(!dynamic && !cacheNames.contains(name)) {
            return cache;
        }

        cache = new CacheRedisCaffeine(name, redisTemplate, caffeineCache());
        Cache oldCache = cacheMap.putIfAbsent(name, cache);
        logger.debug("create cache instance, the cache name is : {}", name);
        return oldCache == null ? cache : oldCache;
    }

    public com.github.benmanes.caffeine.cache.Cache<Object, Object> caffeineCache(){
        Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder();
        return cacheBuilder.build();
    }

    @Override
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


