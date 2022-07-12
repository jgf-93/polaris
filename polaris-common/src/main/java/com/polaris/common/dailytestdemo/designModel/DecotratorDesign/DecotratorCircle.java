package com.polaris.common.dailytestdemo.designModel.DecotratorDesign;

public class DecotratorCircle implements DecotratorShape {
    @Override
    public void draw() {
        System.out.println("CIRCLE圆形");
    }
}
