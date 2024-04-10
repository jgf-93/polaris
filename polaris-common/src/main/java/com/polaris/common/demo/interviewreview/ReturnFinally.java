package com.polaris.common.demo.interviewreview;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ReturnFinally {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println(test1());
        //testA();
        testQueue();
    }

    public static String test1() {
        try {
            return "1";
        } catch (Exception e) {
            return "2";
        } finally {
            return "3";
        }
    }

    private static String n = "测试名字";

    public static void testA() {
        @Data
        class X {
            private String name;
        }
        X x = new X();
        x.setName(n);
        System.out.println("x的名字是" + n);
    }

    public static void testQueue() throws InterruptedException {
        ArrayBlockingQueue<String> aq = new ArrayBlockingQueue<>(10);
        new Thread(() -> {
            System.out.println(111);
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                aq.offer(i + "");
            }
        }).start();
        for (int i = 0; i < 10; i++) {
            System.out.println(aq.poll(11, TimeUnit.SECONDS));
        }
        System.out.println(JSON.toJSONString(aq));
    }
}
