package com.polaris.controller.test;

import com.polaris.common.entity.User;
import com.polaris.common.re.BaseResponse;
import com.polaris.common.rocketmq.PolarisProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private PolarisProducer polarisProducer;

    @RequestMapping("rocketmq/produce")
    @ResponseBody
    public BaseResponse Login() {
        User user = new User();
        user.setUserName("生产者-小蒋-发送mq消息");
        user.setPassword("123456");
        user.setMobile("15757857623");
        SendResult sendResult = polarisProducer.sendSyncMessage(user);
        return BaseResponse.buildSuccessResponse(sendResult.getSendStatus());
    }
}
