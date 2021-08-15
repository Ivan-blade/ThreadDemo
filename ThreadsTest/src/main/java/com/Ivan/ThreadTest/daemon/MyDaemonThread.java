package com.Ivan.ThreadTest.daemon;

public class MyDaemonThread extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("daemon线程。。。");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
