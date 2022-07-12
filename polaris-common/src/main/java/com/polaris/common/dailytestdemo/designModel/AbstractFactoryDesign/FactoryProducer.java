package com.polaris.common.dailytestdemo.designModel.AbstractFactoryDesign;

/**
 * 抽象工厂模式
 */
public class FactoryProducer {
    public static AbstarctFactory getFactory(String type) {
        if ("colorFactory".equalsIgnoreCase(type)) {
            return new ColorFactory();
        } else if ("shapFactory".equalsIgnoreCase(type)) {
            return new ShapeFactory();
        }
        return null;
    }

    public static void main(String[] args) {
        AbstarctFactory factory = getFactory("colorFactory");
        Color color = factory.getColor("yellow");
        color.print();
    }
}
