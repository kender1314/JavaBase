package com.java.learn.stream.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Stream和parallelStream
 * 前者是单管，后者是多管道
 * 后者的处理效率是最高的
 *
 * @ClassName StreamDemo
 * @Description TODO
 * @Author hejiang
 * @Date 2020/7/3 19:35
 */
public class FilterDemo {

    public static void main(String[] args) {
        String contents = null;
        try {
            contents = new String(Files.readAllBytes(Paths.get("src/main/java/com/java/learn/stream/data.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = Arrays.asList(contents.split("\\PL+"));

        //统计data.txt文件中长度大于12的单词数量
        useFor(list);
        useStream(list);
        useparallelStream(list);
    }

    /**
     * 使用普通循环在list中获取需要的值
     *
     * @param list
     */
    private static void useFor(List<String> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > 12) {
                count++;
            }
        }
        System.out.println("for count->" + count);
    }

    /**
     * 使用stream获取需要的值
     *
     * @param list
     */
    private static void useStream(List<String> list) {
        long count = list.stream().filter(w -> w.length() > 12)
                .count();
        System.out.println("stream count->" + count);
    }

    /**
     * 使用stream中的parallelStream（并行获取）获取需要的值
     *
     * @param list
     */
    private static void useparallelStream(List<String> list) {
        long count = list.parallelStream().filter(w -> w.length() > 12)
                .count();
        System.out.println("parallelStream count->" + count);
    }
}
