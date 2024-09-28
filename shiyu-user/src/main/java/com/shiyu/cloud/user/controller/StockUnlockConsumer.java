package com.shiyu.cloud.user.controller;

import com.shiyu.cloud.common.rocketmq.RocketMqConstant;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RocketMQMessageListener(topic = RocketMqConstant.SHIYU_DEFAULT_TOPIC,consumerGroup = RocketMqConstant.SHIYU_DEFAULT_TOPIC)
public class StockUnlockConsumer implements RocketMQListener<List<Integer>> {

    @Override
    public void onMessage(List<Integer> orderIds) {
        System.out.println(orderIds.toString());
    }
}
