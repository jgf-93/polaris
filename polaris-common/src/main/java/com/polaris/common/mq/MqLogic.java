package com.polaris.common.mq;

import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

public abstract class MqLogic {
    protected List<MessageExt> msgs;

    MqLogic(List<MessageExt> msgs) {
        this.msgs = msgs;
    }

    abstract void dealMessage();
}
