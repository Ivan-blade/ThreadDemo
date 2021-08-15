package com.Ivan.ThreadTest.daemon;

public class Main {
    public static void main(String[] args) {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        // 将当前线程设置为daemon线程：守护线程
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        MyThread myThread = new MyThread();
        myThread.start();

    }
}
