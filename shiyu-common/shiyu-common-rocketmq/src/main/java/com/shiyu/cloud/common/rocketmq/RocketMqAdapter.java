package com.shiyu.cloud.common.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

public class RocketMqAdapter {
    private final String nameServer;

    @Autowired
    private RocketMQMessageConverter rocketMqMessageConverter;

    public RocketMqAdapter(String nameServer) {
        this.nameServer = nameServer;
    }


    public RocketMQTemplate getTemplateByTopicName(String topic){
        RocketMQTemplate mqTemplate = new RocketMQTemplate();
        DefaultMQProducer producer = new DefaultMQProducer(topic);
        producer.setNamesrvAddr(nameServer);
        producer.setRetryTimesWhenSendFailed(2);
        producer.setVipChannelEnabled(false);
        producer.setSendMsgTimeout((int) RocketMqConstant.TIMEOUT);
        mqTemplate.setProducer(producer);
        mqTemplate.setMessageConverter(rocketMqMessageConverter.getMessageConverter());
        return mqTemplate;
    }

}
