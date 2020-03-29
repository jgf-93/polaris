package com.polaris.common.mq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import org.apache.log4j.Logger;

public class MqProducer {
    private final Logger logger = Logger.getLogger(MqProducer.class);
    private DefaultMQProducer mqProducer;
    private String producerGroup;
    private String nameServer;

    public void init() {
        logger.info("mqProducer启动了.....");
        mqProducer = new DefaultMQProducer(producerGroup);
        mqProducer.setNamesrvAddr(nameServer);
        mqProducer.setInstanceName(String.valueOf(System.currentTimeMillis()));
        try {
            mqProducer.start();
        } catch (MQClientException e) {
            logger.error("mq启动失败.....", e);
            e.printStackTrace();
        }
        logger.info("mqProducer启动成功了.....");
    }

    public void destroy() {
        mqProducer.shutdown();
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public void setNameServer(String nameServer) {
        this.nameServer = nameServer;
    }

    public DefaultMQProducer getMqProducer() {
        return mqProducer;
    }
}
