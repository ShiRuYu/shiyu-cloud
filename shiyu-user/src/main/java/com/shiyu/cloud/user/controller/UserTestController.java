package com.shiyu.cloud.user.controller;

import com.shiyu.cloud.feign.order.OrderTestFeignClient;
import com.shiyu.cloud.feign.product.ProductTestFeignClient;
import com.shiyu.cloud.feign.user.UserTestFeignClient;
import com.shiyu.cloud.user.log.LoggerUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserTestController implements UserTestFeignClient {

    @Resource
    private OrderTestFeignClient orderTestFeignClient;
    @Resource
    private ProductTestFeignClient productTestFeignClient;

    @Override
    public String testUser(String id) {
        orderTestFeignClient.testOrder(id);
        productTestFeignClient.testProduct(id);
        LoggerUtil.DIGEST_LOGGER.info("test log user：" + id);
        log.info("user test Slf4j");
        System.out.println("user log user");
        return "testUser";
    }
}
