package com.polaris.designModel.ObserverDesign;

public abstract class Observer {

    protected Subject subject;
    
    abstract void update();
}
