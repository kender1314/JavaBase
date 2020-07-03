package com.java.learn.stream.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ParallelStreamDemo
 * @Description TODO
 * @Author hejiang
 * @Date 2020/7/3 20:06
 */
public class ParallelStreamDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(5);
        for (int i = 0; i < 6000; i++) {
            list.add(i);
        }
        compareParallelStreamA(list);
    }

    /**
     * 这个方法中可以看出，stream和for处理的效率差不多，parallelStream明显效率要快得多
     *
     * @param list
     */
    private static void compareParallelStreamA(List<Integer> list) {
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

        start = System.currentTimeMillis();
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


}
