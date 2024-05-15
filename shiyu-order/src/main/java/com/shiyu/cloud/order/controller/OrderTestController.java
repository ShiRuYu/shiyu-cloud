package com.shiyu.cloud.order.controller;

import com.shiyu.cloud.feign.order.OrderTestFeignClient;
import com.shiyu.cloud.order.log.LoggerUtil;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderTestController implements OrderTestFeignClient {

    @Override
    public String testOrder(String id) {
        LoggerUtil.DIGEST_LOGGER.info("test log order：" + id);
        System.out.println("order log order");
        return "testOrder";
    }
}
