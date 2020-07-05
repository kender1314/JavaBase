package com.java.learn.stream.demo;

import com.java.learn.stream.entity.Data;
import com.java.learn.stream.entity.Person;

import java.util.IntSummaryStatistics;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collectors是一个工具类，提供了若干个方法，返回一个Collectors的实现类对象
 * 常用的方法有toList, toSet, toMap, maxBy, minBy, joining
 *
 * CollectorsDemo类中包含：
 * 1. 最大（maxBy），最小（minBy）
 * 2. 合并（joining）
 * 3. 求和（summingInt）
 * 4. 求平均值（averagingInt）
 * @ClassName CollectorsDemo
 * @Description TODO
 * @Author hejiang
 * @Date 2020/7/5 14:37
 */
public class CollectorsDemo {
    public static void main(String[] args) {
        System.out.println("----------------Collectors的相关操作，包括：最大（maxBy），最小（minBy）----------------------------------\n");
        collectorsMaxByAndMinBy();
        System.out.println("----------------Collectors的相关操作，包括：合并（joining）----------------------------------\n");
        collectorsJoining();
        System.out.println("----------------Collectors的相关操作，包括：求和（summingInt）----------------------------------\n");
        collectorsSummingInt();
        System.out.println("----------------Collectors的相关操作，包括：求平均值（averagingInt）----------------------------------\n");
        collectorsAveragingInt();
        System.out.println("----------------Collectors的相关操作，包括：summarizingInt----------------------------------\n");
        collectorsSummarizingInt();
    }

    /**
     * Collectors的相关操作，包括：最大（maxBy），最小（minBy）
     * 最大（maxBy）:获取流中最大的元素
     * 最小（minBy）:获取流中最大=小的元素
     */
    private static void collectorsMaxByAndMinBy(){
        //获取Person流中成绩最大的元素
        System.out.println("获取Person流中成绩最大的元素\n" + Data.getData().stream().collect(Collectors.maxBy((n1, n2) -> n1.getScore() - n2.getScore())));
        //获取Person流中年龄最小的元素
        System.out.println("获取Person流中年龄最小的元素\n" + Data.getData().stream().collect(Collectors.minBy((n1, n2) -> n1.getAge() - n2.getAge())));
    }

    /**
     * Collectors的相关操作，包括：合并（joining）
     * 合并（joining）:将流中的元素以字符串的形式拼接起来
     */
    private static void collectorsJoining(){
        Stream<String> s = Stream.of("he", "hello", "world");

        System.out.println(s.collect(Collectors.joining()));
    }

    /**
     * Collectors的相关操作，包括：求和（summingInt）
     * 求和（summingInt）:将流中的元素转换成为int进行求和
     */
    private static void collectorsSummingInt(){
        System.out.println(Data.getData().stream().collect(Collectors.summingInt(n1 -> n1.getScore())));

    }

    /**
     * Collectors的相关操作，包括：求平均值（averagingInt）
     * 求平均值（averagingInt）:将流中的元素映射成为int类型，再进行求和操作
     */
    private static void collectorsAveragingInt(){
        System.out.println(Data.getData().stream().collect(Collectors.averagingInt(ele -> ele.getScore())));
    }

    /**
     * Collectors的相关操作，包括：summarizingInt
     * summarizingInt:将流中的元素映射成为int类型，最后获取这些数据的描述信息
     */
    private static void collectorsSummarizingInt(){
        IntSummaryStatistics res = Data.getData().stream().collect(Collectors.summarizingInt(Person::getScore));
        System.out.println(res);
    }
}
