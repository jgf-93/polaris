package com.polaris.common.demo.designModel.DecotratorDesign;

public abstract class ShapeDecotrator implements Shape {
    protected Shape shape;

    ShapeDecotrator(Shape shape) {
        this.shape = shape;
    }

    public void draw() {
        shape.draw();
    }
}
