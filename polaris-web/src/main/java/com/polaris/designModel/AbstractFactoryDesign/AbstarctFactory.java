package com.polaris.designModel.AbstractFactoryDesign;

public abstract class AbstarctFactory {
    abstract Color getColor(String type);

    abstract Shape getShape(String type);
}
