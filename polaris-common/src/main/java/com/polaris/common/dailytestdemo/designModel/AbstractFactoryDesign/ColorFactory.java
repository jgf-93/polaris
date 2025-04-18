package com.polaris.common.dailytestdemo.designModel.AbstractFactoryDesign;

public class ColorFactory extends AbstarctFactory {

    public Color getColor(String type) {
        if ("yellow".equalsIgnoreCase(type)) {
            return new Yellow();
        } else if ("blue".equalsIgnoreCase(type)) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String type) {
        return null;
    }
}
