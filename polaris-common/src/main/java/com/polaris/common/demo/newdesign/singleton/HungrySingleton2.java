package com.polaris.common.demo.newdesign.singleton;

public class HungrySingleton2 {

    private HungrySingleton2() {

    }

    static {
        hungrySingleton2 = new HungrySingleton2();
    }

    private static HungrySingleton2 hungrySingleton2;

    public static HungrySingleton2 getHungrySingleton2() {
        return hungrySingleton2;
    }

    public static void main(String[] args) {
        HungrySingleton2 hungrySingleton2=HungrySingleton2.getHungrySingleton2();
        HungrySingleton2 hungrySingleton21=HungrySingleton2.getHungrySingleton2();
        System.out.println(hungrySingleton2==hungrySingleton21);
    }
}
