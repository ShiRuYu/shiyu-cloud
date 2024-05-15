package com.shiyu.cloud.feign.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "shiyu-order",contextId = "testOrder")
public interface OrderTestFeignClient {
    @GetMapping("testOrder")
    String testOrder(String id);
}
