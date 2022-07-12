package com.polaris.common.dailytestdemo.designModel.ObserverDesign;

public class ChineseObserver extends Observer {

    ChineseObserver(Subject subject) {
        this.subject = subject;
        subject.add(this);
    }

    @Override
    void update() {
        System.out.println("语文老师获取到的通知是:" + subject.getState() + "点上课");
    }
}
