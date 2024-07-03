package com.shiyu.cloud.common.cache.rediscaffeine;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class CacheMessage implements Serializable {

    /** */
    @Serial
    private static final long serialVersionUID = 5987219310442078193L;

    private String cacheName;
    private Object key;
    public CacheMessage(String cacheName, Object key) {
        super();
        this.cacheName = cacheName;
        this.key = key;
    }

}
