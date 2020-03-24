package com.polaris.designModel.FactoryDesign;

public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("cat eat fish!!!");
    }
}
