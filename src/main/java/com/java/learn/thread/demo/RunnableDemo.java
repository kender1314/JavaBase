package com.java.learn.thread.demo;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/26 10:54
 */
public class    RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable start...");
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();

        new Thread(() -> {
            System.out.println("Thread start...");
        }).start();
    }
}
