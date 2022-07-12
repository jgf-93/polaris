package com.polaris.common.dailytestdemo.designModel.TemplateDesign;

/**
 * 模板方法--针对抽象父类
 * 意图：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 * <p>
 * 主要解决：一些方法通用，却在每一个子类都重新写了这一方法。
 * <p>
 * 何时使用：有一些通用的方法。
 * <p>
 * 如何解决：将这些通用算法抽象出来。
 * <p>
 * 关键代码：在抽象类实现，其他步骤在子类实现。
 */
public class GameDemo {
    public static void main(String[] args) {
        Game game = new FootBallGame();
        game.play();

        game = new BasketBallGame();
        game.play();
    }
}
