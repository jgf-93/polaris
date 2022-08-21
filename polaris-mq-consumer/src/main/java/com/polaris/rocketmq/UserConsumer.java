package com.polaris.rocketmq;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "polaris-consmer-group"
        , topic = "user_topic")
public class UserConsumer implements RocketMQListener {
    @Override
    public void onMessage(Object message) {
        System.out.println("consumer收到消息内容:" + JSON.toJSONString(message));
    }
}
