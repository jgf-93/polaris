package com.polaris.common.demo.designModel.BuilderDesign;

public class milk extends ColdDrink {
    @Override
    public String name() {
        return "牛奶";
    }

    @Override
    public float price() {
        return 5;
    }
}
