package com.java.learn.thread.demo;

import java.util.concurrent.*;

/**
 * 通常来说，我们使⽤ Runnable 和 Thread 来创建⼀个新的线程。但是它们有⼀个弊
 * 端，就是 run ⽅法是没有返回值的。⽽有时候我们希望开启⼀个线程去执⾏⼀个任
 * 务，并且这个任务执⾏完成后有⼀个返回值。
 * JDK提供了 Callable 接⼝与 Future 类为我们解决这个问题，这也是所谓的“异步”模型。
 *
 * Callable 与 Runnable 类似，同样是只有⼀个抽象⽅法的函数式接⼝。不同的是， Callable 提供的⽅法是有返回值的，⽽且⽀持泛型。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/26 11:37
 */
public class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(0);
        // 模拟计算需要⼀秒
        Thread.sleep(5000);
        return 1;
    }

    /**
     * Future使用方式
     */
    public static void futureDemo() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableDemo callableDemo = new CallableDemo();
        // 注意调⽤get⽅法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使⽤可以设置超时时间的重载get⽅法。
        Future<Integer> result = executorService.submit(callableDemo);
        System.out.println(result.get());
    }

    /**
     * FutureTask使用方式
     * 优点：在很多⾼并发的环境下，有可能Callable和FutureTask会创建多次。FutureTask能够在⾼并发环境下确保任务只执⾏⼀次。
     */
    public static void futureTaskDemo() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableDemo callableDemo = new CallableDemo();
        // 注意调⽤get⽅法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使⽤可以设置超时时间的重载get⽅法。
        FutureTask<Integer> result = new FutureTask<>(callableDemo);
        executorService.submit(result);
        System.out.println(result.get());
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        futureDemo();
        futureTaskDemo();
    }
}
