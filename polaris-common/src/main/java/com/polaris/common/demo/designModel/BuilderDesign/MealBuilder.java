package com.polaris.common.demo.designModel.BuilderDesign;

/**
 * 建造者模式（Builder Pattern）使用多个简单的对象一步一步构建成一个复杂的对象。
 * 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。
 */
public class MealBuilder {
    public static Meal prepare1Meal() {
        Meal meal = new Meal();
        meal.addItems(new Coke());
        meal.addItems(new VegBurger());
        return meal;
    }

    public static Meal prepare2Meal() {
        Meal meal = new Meal();
        meal.addItems(new Coke());
        meal.addItems(new ChickenBurger());
        return meal;
    }

    public static Meal prepare3Meal() {
        Meal meal = new Meal();
        meal.addItems(new milk());
        meal.addItems(new VegBurger());
        return meal;
    }

    public static Meal prepare4Meal() {
        Meal meal = new Meal();
        meal.addItems(new milk());
        meal.addItems(new ChickenBurger());
        return meal;
    }

    public static void main(String[] args) {
        Meal meal1 = MealBuilder.prepare1Meal();
        meal1.showItems();
        System.out.println("套餐1总价格是:" + meal1.getCost());

        Meal meal2 = MealBuilder.prepare1Meal();
        meal2.showItems();
        System.out.println("套餐2总价格是:" + meal2.getCost());

        Meal meal3 = MealBuilder.prepare1Meal();
        meal3.showItems();
        System.out.println("套餐3总价格是:" + meal3.getCost());

        Meal meal4 = MealBuilder.prepare1Meal();
        meal4.showItems();
        System.out.println("套餐4总价格是:" + meal4.getCost());
    }
}
