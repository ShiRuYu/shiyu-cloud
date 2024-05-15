package com.shiyu.cloud.feign.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "shiyu-user",contextId = "testUser")
public interface UserTestFeignClient {
    @GetMapping("testUser")
    String testUser(String id);
}
