package com.polaris.common.demo.designModel.AbstractFactoryDesign;

public class Rectangle implements Shape {
    @Override
    public void create() {
        System.out.println("生成了矩形!!!");
    }
}
