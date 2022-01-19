package com.polaris.common.mq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.log4j.Logger;

import java.util.List;

public class MqConsumer {

    private final Logger logger = Logger.getLogger(MqConsumer.class);

    private DefaultMQPushConsumer defaultMQPushConsumer;

    private String consumerGroup;

    private String nameServer;

    public void init() throws MQClientException {
        logger.info("consumer开始消费....");
        defaultMQPushConsumer = new DefaultMQPushConsumer(consumerGroup);
        defaultMQPushConsumer.setNamesrvAddr(nameServer);
        defaultMQPushConsumer.setInstanceName(String.valueOf(System.currentTimeMillis()));
        //订阅topic
        defaultMQPushConsumer.subscribe("MyTopic", "MyTag");
        // 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
        // 如果非第一次启动，那么按照上次消费的位置继续消费
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 设置为集群消费(区别于广播消费)
        defaultMQPushConsumer.setMessageModel(MessageModel.CLUSTERING);

        defaultMQPushConsumer.setConsumeMessageBatchMaxSize(50);

        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {

            // 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                MessageExt msg = msgs.get(0);
                if (msg.getTopic().equals("MyTopic")) {
                    // TODO 执行Topic的消费逻辑
                    MqLogicFactory.getMqLogicInterface(msg.getTags(), msgs).dealMessage();
                }
                // 如果没有return success ，consumer会重新消费该消息，直到return success
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // Consumer对象在使用之前必须要调用start初始化，初始化一次即可
        defaultMQPushConsumer.start();
        logger.info("DefaultMQPushConsumer start success!");

    }

    public void destroy() {
        defaultMQPushConsumer.shutdown();
    }

    public void setNamesrvAddr(String nameServer) {
        this.nameServer = nameServer;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }
}
