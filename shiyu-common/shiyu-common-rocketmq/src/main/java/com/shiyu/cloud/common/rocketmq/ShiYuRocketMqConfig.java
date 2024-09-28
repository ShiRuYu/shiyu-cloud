package com.shiyu.cloud.common.rocketmq;

import org.apache.rocketmq.spring.autoconfigure.RocketMQAutoConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

/**
 * @author FrozenWatermelon
 * @date 2021/3/30
 */
@RefreshScope
@AutoConfiguration
@ConditionalOnProperty(prefix = "rocketmq", value = "name-server", matchIfMissing = true)
@Import({RocketMQAutoConfiguration.class})
public class ShiYuRocketMqConfig {

    @Value("${rocketmq.name-server:192.168.31.204:9876}")
    private String nameServer;

    @Bean
    public RocketMqAdapter rocketMqAdapter() {
        return new RocketMqAdapter(nameServer);
    }

    @Lazy
    @Bean(destroyMethod = "destroy")
    public RocketMQTemplate defaultMqTemplate(RocketMqAdapter rocketMqAdapter) {
        return rocketMqAdapter.getTemplateByTopicName(RocketMqConstant.SHIYU_DEFAULT_TOPIC);
    }


}
