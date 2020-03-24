package com.polaris.designModel.AbstractFactoryDesign;

public class ShapeFactory extends AbstarctFactory {
    @Override
    public Color getColor(String type) {
        return null;
    }

    public Shape getShape(String type) {
        if ("circle".equalsIgnoreCase(type)) {
            return new Circle();
        } else if ("rectangle".equalsIgnoreCase(type)) {
            return new Rectangle();
        }
        return null;
    }
}
