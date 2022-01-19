package com.polaris.common.demo.designModel.DecotratorDesign;

public class RedDecotrator extends ShapeDecotrator {
    RedDecotrator(DecotratorShape decotratorShape) {
        super(decotratorShape);
    }

    public void draw() {
        redDraw();
        super.draw();
    }

    private void redDraw() {
        System.out.println("这次是红色的.");
    }
}
