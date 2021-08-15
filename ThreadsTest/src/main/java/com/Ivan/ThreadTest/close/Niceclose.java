package com.Ivan.ThreadTest.close;

/**
 * @author hylu.Ivan
 * @date 2021/8/14 下午4:25
 * @description
 */
public class Niceclose extends Thread{

    // 两种方式
    // 守护线程见deaemon
    // 使用内部使用标志位flag,在外部关闭
    private boolean isStart = true;

    public void stopThread() {
        this.isStart = false;
    }

    @Override
    public void run() {
        while (isStart) {
            System.out.println("thread is running...");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        Niceclose niceclose = new Niceclose();
        niceclose.start();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        niceclose.stopThread();
    }
}
