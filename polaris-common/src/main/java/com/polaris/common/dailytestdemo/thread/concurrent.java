package com.polaris.common.dailytestdemo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class concurrent {


    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        concurrent concurrent=new concurrent();
//        concurrent.testCountDownLatch();
        concurrent.testBarrier();
    }
    public void testCountDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(5);
        for(int i=0;i<5;i++){
            int finalI = i;
            new Thread(()->{
                System.out.println(finalI);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("线程协同工具countdownlatch执行完毕");
    }
    public void testBarrier() throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5);
        for(int i=0;i<4;i++){
                int finalI = i;
                new Thread(()->{
                    try {
                        cyclicBarrier.await();
                        System.out.println(finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }).start();
        }
        cyclicBarrier.await();
        if(cyclicBarrier.getNumberWaiting()==0){
            System.out.println("线程准备完毕,开始执行");
        }
    }
}
