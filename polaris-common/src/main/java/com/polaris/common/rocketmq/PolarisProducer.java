package com.polaris.common.rocketmq;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PolarisProducer {
    private static final String producerGroup = "";

    /**
     * rocketmq消息推送模板类
     */
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public <T> SendResult sendSyncMessage(T data) {
        Message message = new GenericMessage(data);
        return rocketMQTemplate.syncSend("user-topic", message);
    }
}
