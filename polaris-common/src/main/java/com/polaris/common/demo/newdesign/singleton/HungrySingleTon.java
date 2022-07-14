package com.polaris.common.demo.newdesign.singleton;

/**
 * 单例模式 饿汉模式
 * 优点
 * 缺点
 *
 */
public class HungrySingleTon {
    public static void main(String[] args) {
        HungrySingleTon hungrySingleTon=HungrySingleTon.getHungrySingleTon();
        HungrySingleTon hungrySingleTon1=HungrySingleTon.getHungrySingleTon();
        System.out.println(hungrySingleTon==hungrySingleTon1);
    }
    public HungrySingleTon() {

    }

    private static HungrySingleTon hungrySingleTon = new HungrySingleTon();

    public static HungrySingleTon getHungrySingleTon() {
        return hungrySingleTon;
    }
}
