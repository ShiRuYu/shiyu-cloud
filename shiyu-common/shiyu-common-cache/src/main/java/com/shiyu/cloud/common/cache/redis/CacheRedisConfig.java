package com.shiyu.cloud.common.cache.redis;

import com.google.common.collect.Maps;
import com.shiyu.cloud.common.cache.CacheConstants;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Map;

@Configuration
@EnableCaching
@Slf4j
public class CacheRedisConfig {

    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * 默认的全局缓存管理器   配置一些序列化器，这样通过缓存管理工具看到的缓存数据就不是乱码了
     * @return
     */
    @Bean
    public RedisCacheManager redisCacheManager() {
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        RedisCacheConfiguration config = RedisCacheConfiguration.
                defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(genericJackson2JsonRedisSerializer));

        Map<@Nullable String, @Nullable RedisCacheConfiguration> caches = Maps.newHashMap();
        RedisCacheConfiguration OrderCache = RedisCacheConfiguration.
                defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(genericJackson2JsonRedisSerializer));
        caches.put(CacheConstants.ORDER_CACHE,OrderCache);

        RedisCacheManager defaultCacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .withInitialCacheConfigurations(caches)
                .cacheDefaults(config).build();

        log.info("the redis defaultCacheManager is loaded successfully!");
        return defaultCacheManager;
    }


}

