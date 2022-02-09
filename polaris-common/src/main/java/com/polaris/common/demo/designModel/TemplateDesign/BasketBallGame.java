package com.polaris.common.demo.designModel.TemplateDesign;

public class BasketBallGame extends Game {
    @Override
    public void initGame() {
        System.out.println("初始化篮球游戏....");
    }

    @Override
    public void start() {
        System.out.println("开始!篮球游戏");
    }

    @Override
    public void end() {
        System.out.println("结束!篮球游戏");
    }
}
