package com.shiyu.cloud.user.controller;

import com.shiyu.cloud.common.rocketmq.RocketMqConstant;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RocketMQMessageListener(topic = RocketMqConstant.STOCK_UNLOCK_TOPIC,consumerGroup = RocketMqConstant.STOCK_UNLOCK_TOPIC)
public class StockUnlockConsumer implements RocketMQListener<List<String>> {

    @Override
    public void onMessage(List<String> orderIds) {
        System.out.println(orderIds.toString());
    }
}
