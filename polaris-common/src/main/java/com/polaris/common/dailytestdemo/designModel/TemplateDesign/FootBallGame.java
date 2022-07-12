package com.polaris.common.dailytestdemo.designModel.TemplateDesign;

public class FootBallGame extends Game {
    @Override
    public void initGame() {
        System.out.println("初始化足球游戏....");
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
