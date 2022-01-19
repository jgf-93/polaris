package com.polaris.common.demo.designModel.BuilderDesign;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> itemList = new ArrayList();

    public void addItems(Item item) {
        itemList.add(item);
    }

    public Float getCost() {
        float sumPrize = 0;
        if (!CollectionUtils.isEmpty(itemList)) {
            sumPrize += itemList.stream().mapToDouble(Item::price).sum();
            return sumPrize;
        }
        return 0f;
    }

    public void showItems() {
        if (!CollectionUtils.isEmpty(itemList)) {
            itemList.stream().forEach(item -> {
                System.out.print("商品名称:" + item.name());
                System.out.print("-商品包装:" + item.packing());
                System.out.print("-商品价格:" + item.price() + "元");
            });
        }
        System.out.print("暂无购买商品");
    }
}
