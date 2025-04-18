package com.polaris.common.dailytestdemo.designModel.BuilderDesign;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new CartonPacking();
    }

    @Override
    public abstract float price();
}
