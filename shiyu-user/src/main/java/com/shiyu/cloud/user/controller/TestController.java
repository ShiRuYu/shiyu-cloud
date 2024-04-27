package com.shiyu.cloud.user.controller;

import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import com.shiyu.cloud.common.rocketmq.RocketMqConstant;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class TestController {
    @Autowired
    private RocketMQTemplate stockMqTemplate;

    @GetMapping
    public String test() {
        List<String> orderIds = Lists.newArrayList("a", "b", "c", "d", "e", "f", "g", "h");
        SendStatus stockSendStatus = stockMqTemplate.syncSend(RocketMqConstant.STOCK_UNLOCK_TOPIC, new GenericMessage<>(orderIds)).getSendStatus();
        return "1111";
    }
}
