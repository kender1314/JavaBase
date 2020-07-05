package com.java.learn.stream.demo;

import com.java.learn.stream.entity.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * parallelStream
 * 使用并发处理
 * 将流中的数据分成若干个块，用不同的线程来进行操作
 * @ClassName ParallelStreamDemo
 * @Description TODO
 * @Author hejiang
 * @Date 2020/7/3 20:06
 */
public class ParallelStreamDemo {
    public static void main(String[] args) {
        compareParallelStream();
        parallelStreamFind();
    }

    /**
     * 这个方法中可以看出，stream和for处理的效率差不多，parallelStream明显效率要快得多
     *
     */
    private static void compareParallelStream() {
        //生成数据
        List<Integer> list = new ArrayList<>(5);
        for (int i = 0; i < 6000; i++) {
            list.add(i);
        }
        //for循环方式
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("for循环方式->" + (end - start));

        //stream循环方式
        start = System.currentTimeMillis();
        list.stream().forEach(m -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        end = System.currentTimeMillis();
        System.out.println("stream方式->" + (end - start));

        //parallelStream循环方式，有两种写法
        start = System.currentTimeMillis();
//        list.stream().parallel().forEach(m -> {
//            try {
//                TimeUnit.MILLISECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        list.parallelStream().forEach(m -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        end = System.currentTimeMillis();
        System.out.println("parallelStream方式->" + (end - start));
    }

    /**
     * 流的相关操作，包括：findFirst, findAny;
     * findFirst：获取流中的第一个元素，无论并行还是串行
     * findAny：获取流中任意一个元素，并不是指的随机的元素
     *          在串行流中，结果相当于findFirst
     *          在并行流中，若干个线程需要争抢cpu时间片，findAny将找到最先抢到cpu时间片的线程中的流的第一个元素
     */
    private static void parallelStreamFind(){
        System.out.println("stream findFirst->>>\n" + Data.getData().stream().findFirst());
        System.out.println("parallelStream findFirst->>>\n" + Data.getData().parallelStream().findFirst());

        System.out.println("stream findAny->>>\n" + Data.getData().stream().findAny());
        System.out.println("parallelStream findAny->>>\n" + Data.getData().parallelStream().findAny());
    }

}
