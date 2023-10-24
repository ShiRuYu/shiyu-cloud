package com.shiyu.cloud.common.cache;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.http.client.utils.CloneUtils;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author cqq01342184
 * @version AbstractMemoryCache.java, v 0.1 2023年08月04日 上午9:24 cqq01342184
 */
public abstract class AbstractMemoryCache<PK, T> implements InitializingBean {

    private LoadingCache<PK,T> cache;

    protected abstract CacheBuilder<Object,Object> getCacheBuilder(CacheBuilder<Object,Object> cacheBuilder);

    protected abstract CacheLoader<PK,T> getCacheLoader();

    protected LoadingCache<PK,T> getCache() {
        return cache;
    }

    public T getValue(PK pk) throws Exception {
        try {
            return CloneUtils.cloneObject(this.cache.get(pk));
        } catch (CloneNotSupportedException | ExecutionException e) {
            throw new Exception(e);
        }
    }

    public T getValueCallable(PK pk, Callable<T> callable) throws Exception {
        return this.cache.get(pk, callable);
    }

    public void setValue(PK pk, T t) {
        this.cache.put(pk, t);
    }

    @Override
    public void afterPropertiesSet() {
        CacheLoader<PK,T> cacheLoader = this.getCacheLoader();
        CacheBuilder<Object,Object> cacheBuilder = this.getCacheBuilder(CacheBuilder.newBuilder());
        this.cache = cacheBuilder.build(cacheLoader);
    }

}
