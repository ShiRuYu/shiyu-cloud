package com.shiyu.cloud.product.controller;

import com.shiyu.cloud.feign.product.ProductTestFeignClient;
import com.shiyu.cloud.product.log.LoggerUtil;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductTestController implements ProductTestFeignClient {

    @Override
    public String testProduct(String id) {
        LoggerUtil.DIGEST_LOGGER.info("test log product：" + id);
        System.out.println("product log product");
        return "testProduct";
    }
}
