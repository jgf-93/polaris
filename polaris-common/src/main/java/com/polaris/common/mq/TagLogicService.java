package com.polaris.common.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

public class TagLogicService extends MqLogic {

    TagLogicService(List<MessageExt> msgs) {
        super(msgs);
    }

    @Override
    public void dealMessage() {
        msgs.stream().forEach(msg -> {
            System.out.println("接收到消息:" + JSON.toJSONString(msg));
        });
    }
}
