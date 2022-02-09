package com.polaris.common.demo.designModel.proxy;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 */
public class JdkProxyDemo {

    public static void main(String[] args) {
        JdkProxyDemo.CarService carService = new JdkProxyDemo().new CarService();
        Car car = (Car) Proxy.newProxyInstance(carService.getClass().getClassLoader()
                , carService.getClass().getInterfaces()
                , (proxy, method, args1) -> {
                    System.out.println("ing");
                    return method.invoke(carService, args1);
                });
        car.start();
    }

    class CarService implements Car {
        public void start() {
            System.out.println("caring");
        }
    }

    interface Car {
        void start();
    }
}
