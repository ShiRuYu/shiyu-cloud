package com.shiyu.cloud.feign.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shiyu-product",contextId = "testProduct")
public interface ProductTestFeignClient {

    @GetMapping("testProduct")
    String testProduct(@RequestParam("id") String id);
}
