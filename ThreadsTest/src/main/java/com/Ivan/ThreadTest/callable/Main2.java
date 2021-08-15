package com.Ivan.ThreadTest.callable;

import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                // 线程池数量5，最大线程数5
                5, 5,
                // 空闲1秒关闭
                1, TimeUnit.SECONDS,
                // 当前五个线程都在使用的情况下，其他任务存在阻塞队列中，容量为10
                new ArrayBlockingQueue<>(10)
        ) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                // 如果在call方法执行过程中有错误，则可以在此处进行处理
//                super.afterExecute(r, t);
                System.out.println("任务执行完毕 " + t);
            }
        };

        Future<String> future = executor.submit(myCallable);

        String result = future.get();
        System.out.println(result);

        executor.shutdown();
    }
}
