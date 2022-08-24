package com.polaris.rocketmq;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

@RocketMQMessageListener(consumerGroup = "polaris-consumer-orderly-group", topic = "user_orderly_topic", consumeMode = ConsumeMode.ORDERLY)
public class UserOrderlyConsumer implements RocketMQListener {

    @Override
    public void onMessage(Object message) {

    }
}
