package com.shiyu.cloud.feign.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shiyu-order",contextId = "testOrder")
public interface OrderTestFeignClient {
    @GetMapping("testOrder")
    String testOrder(@RequestParam("id") String id);
}
