package com.Ivan.ThreadTest.produceAndConsumer;

/**
 * 生产者消费者模型，双方互相唤醒等待
 * 双方都是单线程模式
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyQueue myQueue = new MyQueue();

        for (int i = 0; i < 5; i++) {
            new ProducerThread(myQueue).start();
            new ConsumerThread(myQueue).start();
        }

        Thread.sleep(10000);
        // 进程结束
        System.exit(0);
    }
}
