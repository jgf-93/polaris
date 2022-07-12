package com.polaris.common.dailytestdemo.designModel.proxy.cglib;


/**
 * cglib动态代理
 */
public class CglibDemo {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        AnimalService animalService= (AnimalService) cglibProxy.getProxy(AnimalService.class);
        animalService.eat();
    }
}
