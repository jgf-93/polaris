package com.polaris.controller.test;

import com.polaris.common.entity.User;
import com.polaris.common.re.BaseResponse;
import com.polaris.common.rocketmq.PolarisProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private PolarisProducer polarisProducer;
    @Value("${user.topic}")
    private String topic;
    @Value("${user.tag}")
    private String tag;

    /**
     * 同步消息测试
     *
     * @return
     */
    @RequestMapping("rocketmq/produce")
    @ResponseBody
    public BaseResponse Login(String messageType) {
        if (StringUtils.isEmpty(messageType)) {
            return BaseResponse.buildErrorResponse("参数异常");
        }
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId((long) i);
            user.setUserName("生产者-小蒋-发送mq消息");
            user.setPassword("123456");
            if (i > 88) {
                user.setMobile("11111111111");
            } else {
                user.setMobile("15757857623");
            }
            //发送同步消息
            if ("1".equals(messageType)) {
                //发送同步消息
                polarisProducer.sendSyncMessage(topic, tag, user);
            } else if ("2".equals(messageType)) {
                //发送同步分区顺序消息
                polarisProducer.sendShardingKeyMessageOrderly(topic, tag, user, user.getMobile());
            } else if ("3".equals(messageType)) {
                //发送同步延时消息
                polarisProducer.sendDelaySyncMessage(topic, tag, user, 3000, 3);
            }
        }
        return BaseResponse.buildSuccessResponse();

    }
}
