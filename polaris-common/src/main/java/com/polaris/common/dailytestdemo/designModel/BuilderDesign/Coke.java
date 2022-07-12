package com.polaris.common.dailytestdemo.designModel.BuilderDesign;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "咖啡";
    }

    @Override
    public float price() {
        return 15;
    }
}
