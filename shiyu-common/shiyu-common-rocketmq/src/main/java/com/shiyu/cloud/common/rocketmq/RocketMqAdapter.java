package com.shiyu.cloud.common.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.autoconfigure.RocketMQAutoConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@RefreshScope
@Configuration
@Import({RocketMQAutoConfiguration.class})
public class RocketMqAdapter {

    @Autowired
    private RocketMQMessageConverter rocketMqMessageConverter;

    @Value("${rocketmq.name-server:192.168.31.204:9876}")
    private String nameServer;

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
