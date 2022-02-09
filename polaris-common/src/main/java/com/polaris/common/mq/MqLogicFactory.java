package com.polaris.common.mq;

import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

public class MqLogicFactory {

    public static MqLogic getMqLogicInterface(String type, List<MessageExt> msgs) {
        switch (type) {
            case "MyTag":
                return new TagLogicService(msgs);
            default:
                return null;
        }
    }
}
