package com.polaris.common.dailytestdemo.designModel.AdapterDesign;

public class VLCPlayer implements VideoPlayer {

    @Override
    public void playMp4(String name) {

    }

    @Override
    public void playVLC(String name) {
        System.out.println("播放了" + name + "............");
    }
}
