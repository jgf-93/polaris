package com.polaris.common.dailytestdemo.designModel.ObserverDesign;

public abstract class Observer {

    protected Subject subject;
    
    abstract void update();
}
