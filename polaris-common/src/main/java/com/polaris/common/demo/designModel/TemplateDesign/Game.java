package com.polaris.common.demo.designModel.TemplateDesign;

public abstract class Game {
    abstract void initGame();

    abstract void start();

    abstract void end();

    public final void play() {
        //初始化游戏
        initGame();
        //开始游戏
        start();
        //结束游戏
        end();
    }

}
