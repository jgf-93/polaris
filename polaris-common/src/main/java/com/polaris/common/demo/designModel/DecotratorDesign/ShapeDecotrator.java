package com.polaris.common.demo.designModel.DecotratorDesign;

public abstract class ShapeDecotrator implements DecotratorShape {
    protected DecotratorShape decotratorShape;

    ShapeDecotrator(DecotratorShape decotratorShape) {
        this.decotratorShape = decotratorShape;
    }

    public void draw() {
        decotratorShape.draw();
    }
}
