package com.polaris.common.dailytestdemo.designModel.ObserverDesign;

public class EnglishObserver extends Observer {

    EnglishObserver(Subject subject) {
        this.subject = subject;
        subject.add(this);
    }

    @Override
    void update() {
        System.out.println("英文老师获取到的通知是:" + subject.getState() + "点上课");
    }
}
