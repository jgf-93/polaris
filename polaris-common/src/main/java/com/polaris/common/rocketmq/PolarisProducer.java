package com.polaris.common.rocketmq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PolarisProducer {

    /**
     * rocketmq消息推送模板类
     */
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步消息
     *
     * @param topic
     * @param tag
     * @param data
     * @param <T>
     * @return
     */
    public <T> SendResult sendSyncMessage(String topic, String tag, T data) {
        Message message = new GenericMessage(data);
        return rocketMQTemplate.syncSend(topic + ":" + tag, message);
    }

    /**
     * 同步发送延迟消息
     */
    public <T> SendResult sendDelaySyncMessage(String topic, String tag, T data, long timeOut, int delayLevel) {
        Message message = new GenericMessage(data);
        return rocketMQTemplate.syncSend(topic + ":" + tag, message, timeOut, delayLevel);
    }

    /**
     * 分区顺序消息
     */
    public <T> SendResult sendShardingKeyMessageOrderly(String topic, String tag, T data, String shardingKey) {
        Message message = new GenericMessage(data);
        return rocketMQTemplate.syncSendOrderly(topic + ":" + tag, message, shardingKey);
    }

    /**
     * 异步发送消息
     */
    public <T> void asyncSend(String topic, String tag, T data, SendCallback sendCallback) {
        Message message = new GenericMessage(data);
        rocketMQTemplate.asyncSend(topic + ":" + tag, message, sendCallback);
    }
}
