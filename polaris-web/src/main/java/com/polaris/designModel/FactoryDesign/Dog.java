package com.polaris.designModel.FactoryDesign;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("dog eat chicken!!!");
    }
}
