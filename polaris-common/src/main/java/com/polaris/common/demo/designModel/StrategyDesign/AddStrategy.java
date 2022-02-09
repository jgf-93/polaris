package com.polaris.common.demo.designModel.StrategyDesign;

import org.springframework.util.Assert;

public class AddStrategy implements Strategy {
    @Override
    public void doOperation(int var1, int var2) {
        Assert.notNull(var1, "数字1不能为空!");
        Assert.notNull(var2, "数字2不能为空!");
        System.out.println(var1 + var2);
    }
}
