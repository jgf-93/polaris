package com.polaris.common.demo.designModel.ObserverDesign;

public abstract class Observer {

    protected Subject subject;
    
    abstract void update();
}
