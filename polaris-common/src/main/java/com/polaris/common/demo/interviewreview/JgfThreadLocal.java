package com.polaris.common.demo.interviewreview;

import java.lang.ref.WeakReference;

public class JgfThreadLocal {

    public static void main(String[] args) throws InterruptedException {
        //testThreadLocal();
        //testWeak();
        testGc();
    }
    public static void testThreadLocal(){
        InheritableThreadLocal<String> tt=new InheritableThreadLocal();
        tt.set("InheritableThreadLocal-测试多线程共享");
        ThreadLocal<String> t=new ThreadLocal<>();
        t.set("ThreadLocal测试多线程共享");
        for(int i=0;i<5;i++){
            new Thread(()->{
                System.out.println(tt.get());
                System.out.println(t.get());
            }).start();
        }
    }

    /**
     * 弱引用
     * @throws InterruptedException
     */
    public static void testWeak() throws InterruptedException {
        Object object=new Object();
        WeakReference<Object> wr=new WeakReference<>(object);
        System.gc();
        System.out.println("第一次gc"+wr.get());
        object=null;
        System.gc();
        System.out.println("第二次gc"+wr.get());
    }

    /**
     * 强引用
     */
    public static void testGc(){
        Object object=new Object();
        Object ob2=object;
        object=null;
        System.gc();
        System.out.println(object);
        System.out.println(ob2);

    }
}
