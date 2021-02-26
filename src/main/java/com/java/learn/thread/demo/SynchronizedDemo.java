package com.java.learn.thread.demo;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/26 14:10
 */
public class SynchronizedDemo {
    private static synchronized void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 结果1：
     * thread1:RUNNABLE
     * thread2:BLOCKED
     * 结果2：
     * thread1:RUNNABLE
     * thread2:RUNNABLE
     *
     * 为什么会出现这种情况？
     * 因为可能会出现main线程调用两个线程的start()⽅法时，两个线程还没真正开始争夺锁，就已经打印此时两个线程的状态了。
     *
     * 在thread1.start()与thread2.start()之间添加Thread.sleep(2000)，
     * 在线程thread1执⾏run()调⽤testMethod()之后，线程thread1休眠了5000ms（注意这⾥是没有
     * 释放锁的），main线程休眠完毕，接着thread2线程执⾏的时候是争夺不到锁的，那么thread1会出现超时等待，thread2会出现被锁住的情况
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(SynchronizedDemo::sleep, "thread1");
        Thread thread2 = new Thread(SynchronizedDemo::sleep, "thread2");
        thread1.start();
        thread2.start();
        System.out.println(thread1.getName() + ":" + thread1.getState());
        System.out.println(thread2.getName() + ":" + thread2.getState());
    }
}
