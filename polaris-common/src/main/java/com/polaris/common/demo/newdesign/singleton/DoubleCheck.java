package com.polaris.common.demo.newdesign.singleton;

/**
 * 双重检查懒汉
 */
public class DoubleCheck {
    private static volatile DoubleCheck doubleCheck;
    private DoubleCheck(){}
    public static DoubleCheck getDoubleCheck(){
        if(doubleCheck==null){
            synchronized (DoubleCheck.class){
                if(doubleCheck==null){
                    doubleCheck=new DoubleCheck();
                }
            }
        }
        return doubleCheck;
    }

    public static void main(String[] args) {
        DoubleCheck doubleCheck1=DoubleCheck.getDoubleCheck();
        DoubleCheck doubleCheck2=DoubleCheck.getDoubleCheck();
        System.out.println(doubleCheck1==doubleCheck2);
    }
}
