package com.shiyu.cloud.feign.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "shiyu-product",contextId = "testProduct")
public interface ProductTestFeignClient {

    @GetMapping("testProduct")
    String testProduct(String id);
}
