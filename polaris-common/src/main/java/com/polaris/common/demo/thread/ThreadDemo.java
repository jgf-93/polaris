package com.polaris.common.demo.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {
    private static Lock lock=new ReentrantLock();
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       //System.out.println(Runtime.getRuntime().availableProcessors());
//        List<Callable<String>> callableList = new ArrayList<>();
//        EatCallble eatCallble1 = new EatCallble();
//        eatCallble1.setName("吃面");
//        callableList.add(eatCallble1);
//        EatCallble eatCallble2 = new EatCallble();
//        eatCallble2.setName("吃饭");
//        callableList.add(eatCallble2);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1
//                , 5
//                , 5
//                , TimeUnit.MILLISECONDS
//                , new ArrayBlockingQueue<>(5)
//                , r -> new Thread(r, "吃饭线程")
//                , (r, executor) -> System.out.println("线程已经满了，任务拒绝"));
//        List<Future<String>> futureList=threadPoolExecutor.invokeAll(callableList);
//        for(Future future:futureList){
//            System.out.println(future.get());
//        }
        //lock();
        new Thread(()->{
            System.out.println("修改值:"+7);
            LockContext.put("5", "7");
        }).start();
    }

    public static class EatCallble implements Callable<String> {
        private String name;

        @Override
        public String call() throws Exception {
            return name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static void lock() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("getLock");
            Thread th=new Thread(()->{
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            th.start();
            Thread.sleep(3000l);
            th.interrupt();

        }finally {
            lock.unlock();
        }
    }
}
