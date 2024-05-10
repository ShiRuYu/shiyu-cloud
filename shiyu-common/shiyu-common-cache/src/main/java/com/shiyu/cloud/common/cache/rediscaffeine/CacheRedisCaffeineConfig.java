package com.shiyu.cloud.common.cache.rediscaffeine;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.Objects;

@AutoConfiguration
@EnableCaching
public class CacheRedisCaffeineConfig {

    @Bean
    @ConditionalOnBean(RedisTemplate.class)
    public CacheRedisCaffeineManager cacheRedisCaffeineManager(RedisTemplate<Object, Object> redisTemplate) {
        return new CacheRedisCaffeineManager(redisTemplate);
    }

    @Bean
    @ConditionalOnBean(CacheRedisCaffeineManager.class)
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisTemplate<Object, Object> redisTemplate,
                                                                       CacheRedisCaffeineManager cacheRedisCaffeineManager) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(Objects.requireNonNull(redisTemplate.getConnectionFactory()));
        CacheMessageListener cacheMessageListener = new CacheMessageListener(redisTemplate, cacheRedisCaffeineManager);
        redisMessageListenerContainer.addMessageListener(cacheMessageListener, new ChannelTopic("redis-cache"));
        return redisMessageListenerContainer;
    }
}


