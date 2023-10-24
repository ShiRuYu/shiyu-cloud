package com.shiyu.cloud.common.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.shiyu.cloud.common.exception.ServiceException;
import com.shiyu.cloud.common.response.HttpStatusEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//import org.springframework.stereotype.Component;
//@Component
public class ExampleCache extends AbstractMemoryCache<String, Map<String, Object>> {

    // 过期时间: 1天
    private static final int EXPIRE_DAY_TIME = 1;

    // 最多保存的key的数量
    private static final int MAX_KEY_SIZE = 500;

    // 设置存储数量和过期时间
    @Override
    protected CacheBuilder<Object,Object> getCacheBuilder(CacheBuilder<Object,Object> cacheBuilder) {
        return cacheBuilder.maximumSize(MAX_KEY_SIZE).expireAfterWrite(EXPIRE_DAY_TIME, TimeUnit.DAYS);
    }

    @Override
    protected CacheLoader<String,Map<String, Object>> getCacheLoader() {
        return new CacheLoader<String,Map<String, Object>>() {

            @Override
            public Map<String, Object> load(String key) {
                return new HashMap<String, Object>();
            }
        };
    }

    // 根据key获取token值
    public Map<String, Object> genToken(String key) {
        Map<String, Object> value = null;
        try {
            value = super.getValue(key);
        } catch (Exception e) {
            throw new ServiceException(HttpStatusEnum.MOVED_PERM.getCode(),HttpStatusEnum.MOVED_PERM.getMessage());
        }
        return value;
    }

    public Map<String, Object> get(String key) {
        Map<String, Object> value = null;
        try {
            value = super.getValueCallable(key, () -> {
                Map<String, Object> v = new HashMap();
                //设置回缓存
                ExampleCache.super.setValue(key, v);
                return v;
            });
        } catch (Exception e) {
            throw new ServiceException(HttpStatusEnum.MOVED_PERM.getCode(),HttpStatusEnum.MOVED_PERM.getMessage());
        }
        return value;
    }

    // 在guava中根据key缓存值
    public void setCache(String key, Map<String, Object> token) {
        super.setValue(key, token);
    }

}
