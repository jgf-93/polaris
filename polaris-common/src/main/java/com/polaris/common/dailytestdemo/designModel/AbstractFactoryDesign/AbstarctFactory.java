package com.polaris.common.dailytestdemo.designModel.AbstractFactoryDesign;

public abstract class AbstarctFactory {
    abstract Color getColor(String type);

    abstract Shape getShape(String type);
}
