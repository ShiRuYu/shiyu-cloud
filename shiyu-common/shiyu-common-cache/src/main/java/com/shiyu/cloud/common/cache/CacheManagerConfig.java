package com.shiyu.cloud.common.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Maps;
import com.shiyu.cloud.common.cache.rediscaffeine.CacheMessageListener;
import com.shiyu.cloud.common.cache.rediscaffeine.RedisCaffeineCacheManager;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Configuration
@Slf4j
public class CacheManagerConfig {
    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * 创建基于Caffeine的Cache Manager
     */
    @Bean
    @Primary
    public CaffeineCacheManager caffeineCacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        Cache<Object, Object> build = Caffeine.newBuilder().recordStats()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .maximumSize(10000)
                .build();
        caffeineCacheManager.registerCustomCache(CacheConstants.DEFAULT_CACHE,build);
        return caffeineCacheManager;
    }

    /**
     * 默认的全局缓存管理器   配置一些序列化器，这样通过缓存管理工具看到的缓存数据就不是乱码了
     */
    @Bean
    @DependsOn(value = {"redisTemplate"})
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
        caches.put(CacheConstants.DEFAULT_CACHE,OrderCache);

        RedisCacheManager defaultCacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .withInitialCacheConfigurations(caches)
                .cacheDefaults(config).build();

        log.info("the redis defaultCacheManager is loaded successfully!");
        return defaultCacheManager;
    }

    @Bean
    @DependsOn(value = {"redisCacheManager"})
    public RedisCaffeineCacheManager redisCaffeineCacheManager(RedisTemplate<Object, Object> redisTemplate) {
        return new RedisCaffeineCacheManager(redisTemplate);
    }

    @Bean
    @DependsOn(value = {"redisCaffeineCacheManager"})
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisTemplate<Object, Object> redisTemplate,
                                                                       RedisCaffeineCacheManager redisCaffeineCacheManager) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(Objects.requireNonNull(redisTemplate.getConnectionFactory()));
        CacheMessageListener cacheMessageListener = new CacheMessageListener(redisTemplate, redisCaffeineCacheManager);
        redisMessageListenerContainer.addMessageListener(cacheMessageListener, new ChannelTopic("redis-cache"));
        return redisMessageListenerContainer;
    }

}
