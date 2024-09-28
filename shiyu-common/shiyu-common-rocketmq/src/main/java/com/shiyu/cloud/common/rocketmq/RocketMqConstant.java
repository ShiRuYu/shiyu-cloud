package com.shiyu.cloud.common.rocketmq;

/**
 * nameserver用;分割
 * 同步消息，如果两次
 */
public class RocketMqConstant {

    // 延迟消息 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h (1-18)

    /**
     * 取消订单时间，实际上30分钟
     */
    public static final int CANCEL_ORDER_DELAY_LEVEL = 16;

    /**
     * 默认发送消息超时时间
     */
    public static final long TIMEOUT = 10000;


    /**
     * 默认topic
     */
    public static final String SHIYU_DEFAULT_TOPIC = "shiyu-default-topic";


}
