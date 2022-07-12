package com.polaris.common.dailytestdemo.designModel.BuilderDesign;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new PlasticBagPacking();
    }

    @Override
    public abstract float price();
}
