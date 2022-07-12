package com.polaris.common.dailytestdemo.designModel.AdapterDesign;

public class Mp4Player implements VideoPlayer {
    @Override
    public void playMp4(String name) {
        System.out.println("播放了" + name + "............");
    }

    @Override
    public void playVLC(String name) {

    }
}
