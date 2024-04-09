package com.polaris.common.demo.fourthreview;

public class ThreadWait {
    T t = new T();

    public static void main(String[] args) throws InterruptedException {
        ThreadWait tr = new ThreadWait();
        new Thread(() -> {
            try {
                tr.testA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(10000);
        tr.testB();
    }

    public void testA() throws InterruptedException {
        synchronized (t) {
            t.wait();
        }
        System.out.println(111);
    }

    public void testB() {
        System.out.println("cs");
        synchronized (t) {
            t.notify();
        }

    }

    class T {

    }
}
