package com.polaris.common.demo.designModel.BuilderDesign;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "鸡腿汉堡";
    }

    @Override
    public float price() {
        return 30;
    }
}
