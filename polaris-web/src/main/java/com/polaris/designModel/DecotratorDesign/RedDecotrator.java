package com.polaris.designModel.DecotratorDesign;

public class RedDecotrator extends ShapeDecotrator {
    RedDecotrator(Shape shape) {
        super(shape);
    }

    public void draw() {
        redDraw();
        super.draw();
    }

    private void redDraw() {
        System.out.println("这次是红色的.");
    }
}
