package com.shiyu.cloud.user.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private Map<String,CacheManager> cacheManagers;

    @GetMapping("b")
    @Cacheable(key = "'cache_user_id_' + #id", value = "userIdCachew4er")
    public String b(String id) {
        System.out.println("222222222222");
        return "1111111";
    }
}
