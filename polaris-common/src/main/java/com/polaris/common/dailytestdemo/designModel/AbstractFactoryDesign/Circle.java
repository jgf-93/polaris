package com.polaris.common.dailytestdemo.designModel.AbstractFactoryDesign;

public class Circle implements Shape {
    @Override
    public void create() {
        System.out.println("生成了圆!!!!");
    }
}
