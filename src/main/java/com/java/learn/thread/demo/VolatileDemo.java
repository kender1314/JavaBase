package com.java.learn.thread.demo;

/**
 * 需求：让线程A输出0，然后线程B输出1，再然后线程A输出2…以此类推。我应该怎样实现呢？
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/26 14:59
 */
public class VolatileDemo {
    private static volatile Integer count = 0;

    /**
     * count++ 并不是⼀个原⼦操作，所以我们需要使⽤ synchronized 给它“上锁”。
     * 这样是为了防止当其中一个线程在执行过程中出错，能够进行操作回滚
     */
    private static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (count < 10) {
                if (count % 2 == 0) {
                    System.out.println("A----->" + count);
                    synchronized (this) {
                        count++;
                    }
                }
            }
        }
    }

    private static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (count < 10) {
                if (count % 2 == 1) {
                    System.out.println("B----->" + count);
                    synchronized (this) {
                        count++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }
}
