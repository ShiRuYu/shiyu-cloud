package com.shiyu.cloud.user.controller;

import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import com.shiyu.cloud.common.rocketmq.RocketMqConstant;
import com.shiyu.cloud.feign.order.OrderTestFeignClient;
import com.shiyu.cloud.feign.product.ProductTestFeignClient;
import com.shiyu.cloud.feign.user.UserTestFeignClient;
import com.shiyu.cloud.user.log.LoggerUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserTestController implements UserTestFeignClient {

    @Resource
    private OrderTestFeignClient orderTestFeignClient;
    @Resource
    private ProductTestFeignClient productTestFeignClient;
    @Resource
    private RocketMQTemplate stockMqTemplate;

    @Override
    public String testUser(String id) {
        orderTestFeignClient.testOrder(id);
        productTestFeignClient.testProduct(id);
        LoggerUtil.DIGEST_LOGGER.info("test log user：" + id);
        log.info("user test Slf4j");
        System.out.println("user log user");
        return "testUser";
    }

    @GetMapping("test/send")
    public String send(){
        SendResult sendResult = stockMqTemplate.syncSend(RocketMqConstant.SHIYU_DEFAULT_TOPIC, new GenericMessage<>(Lists.newArrayList(1, 2, 3)), RocketMqConstant.TIMEOUT, RocketMqConstant.CANCEL_ORDER_DELAY_LEVEL);
        return JSONUtil.toJsonStr(sendResult);
    }
}
