package com.polaris.service;

import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;
import com.polaris.common.mq.MqProducer;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


// 配置Spring中的测试环境
@RunWith(SpringJUnit4ClassRunner.class)
// 指定Spring的配置文件路径
@ContextConfiguration(locations = {"classpath*:/spring/spring-*.xml"})
public class MqTestService {
    private Logger logger = Logger.getLogger(MqTestService.class);
    @Resource
    private MqProducer mqProducer;

    @Test
    public void mqTest() {
        Message msg = new Message("MyTopic", "MyTag", "测试mq消息".getBytes());
        SendResult sendResult = null;
        try {
            sendResult = mqProducer.getMqProducer().send(msg);
        } catch (Exception e) {
            logger.error(e.getMessage() + String.valueOf(sendResult));
        }
        // 当消息发送失败时如何处理
        if (sendResult == null || sendResult.getSendStatus() != SendStatus.SEND_OK) {
            // TODO
        }
    }
}
