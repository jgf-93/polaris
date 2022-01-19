package com.polaris.common.demo.designModel.FactoryDesign;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("dog eat chicken!!!");
    }
}
