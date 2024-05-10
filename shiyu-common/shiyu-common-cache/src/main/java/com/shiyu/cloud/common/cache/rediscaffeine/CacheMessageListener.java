package com.shiyu.cloud.common.cache.rediscaffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

public class CacheMessageListener implements MessageListener {
    private final Logger logger = LoggerFactory.getLogger(CacheMessageListener.class);
    private RedisTemplate<Object, Object> redisTemplate;
    private CacheRedisCaffeineManager cacheRedisCaffeineManager;
    public CacheMessageListener(RedisTemplate<Object, Object> redisTemplate,
                                CacheRedisCaffeineManager cacheRedisCaffeineManager) {
        super();
        this.redisTemplate = redisTemplate;
        this.cacheRedisCaffeineManager = cacheRedisCaffeineManager;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        CacheMessage cacheMessage = (CacheMessage) redisTemplate.getValueSerializer().deserialize(message.getBody());
        logger.debug("recevice a redis topic message, clear local cache, the cacheName is {}, the key is {}", cacheMessage.getCacheName(), cacheMessage.getKey());
        cacheRedisCaffeineManager.clearLocal(cacheMessage.getCacheName(), cacheMessage.getKey());
    }
}
