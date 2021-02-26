package com.java.learn.thread.demo;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/26 10:51
 */
public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("Thread start...");
    }

    public static void main(String[] args) {
        ThreadDemo myThread = new ThreadDemo();
        myThread.start();
    }
}
