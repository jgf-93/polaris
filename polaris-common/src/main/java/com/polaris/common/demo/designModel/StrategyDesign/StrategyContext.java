package com.polaris.common.demo.designModel.StrategyDesign;

/**
 * 策略模式
 * 意图：定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。
 * <p>
 * 主要解决：在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
 * <p>
 * 何时使用：一个系统有许多许多类，而区分它们的只是他们直接的行为。
 * <p>
 * 如何解决：将这些算法封装成一个一个的类，任意地替换。
 * 使用场景：
 * 1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，
 * 那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。
 * 2、一个系统需要动态地在几种算法中选择一种。
 * 3、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
 * <p>
 * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
 * <p>
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 */
public class StrategyContext {
    private Strategy strategy;

    StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    void doOperation(int var1, int var2) {
        strategy.doOperation(var1, var2);
    }

    public static void main(String[] args) {
        //加
        StrategyContext context = new StrategyContext(new AddStrategy());
        context.doOperation(2, 1);
        //减
        context = new StrategyContext(new SubtractionStrategy());
        context.doOperation(2, 1);
        //乘
        context = new StrategyContext(new RideStrategy());
        context.doOperation(2, 1);
        //除
        context = new StrategyContext(new ExceptStrategy());
        context.doOperation(2, 1);
    }
}
