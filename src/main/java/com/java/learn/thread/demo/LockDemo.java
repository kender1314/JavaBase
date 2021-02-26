package com.java.learn.thread.demo;

/**
 * 一个简单的锁的小程序
 * 要求：让ThreadA执行完成之后，才让ThreadB执行
 *
 * 这⾥声明了⼀个名字为 lock 的对象锁。我们在 ThreadA 和 ThreadB 内需要同步的
 * 代码块⾥，都是⽤ synchronized 关键字加上了同⼀个对象锁 lock 。
 * 上⽂我们说到了，根据线程和锁的关系，同⼀时间只有⼀个线程持有⼀个锁，那么
 * 线程B就会等线程A执⾏完成后释放 lock ，线程B才能获得锁 lock 。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/26 14:40
 */
public class LockDemo {
    private static final Object LOCK = new Object();

    private static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK) {
                //可以使用LOCK.wait()让线程ThreadA进入等待
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 100; i++) {
                    System.out.println("A---->" + i);
                }
            }
        }
    }

    private static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("B---->" + i);
                }
                //可以使用LOCK.notify()将线程ThreadA唤醒，如果不唤醒的话，线程ThreadB执行完后，程序就会一直处于等待状态，不会关闭
                LOCK.notify();
            }
        }
    }

    /**
     * 这⾥在主线程⾥使⽤sleep⽅法睡眠了10毫秒，是为了防⽌线程B先得到锁。
     * 因为如果同时start，线程A和线程B都是出于就绪状态，操作系统可能会先让
     * B运⾏。这样就会先输出B的内容，然后B执⾏完成之后⾃动释放锁，线程A再执⾏。
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }
}
