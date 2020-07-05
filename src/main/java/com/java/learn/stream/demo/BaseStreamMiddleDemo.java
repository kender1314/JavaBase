package com.java.learn.stream.demo;

import com.java.learn.stream.entity.Data;
import com.java.learn.stream.entity.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流的中间操作
 * BaseStreamMiddleDemo类包含：
 * 1. 过滤器（filter）
 * 2. 去重（distinct）
 * 3. 排序（sorted）
 * 4. 限制（limit），跳过（skip）
 * 5. 元素映射（map）
 * 6. 映射（flatMap）
 *
 * @ClassName BaseStreamMiddleDemo
 * @Description TODO
 * @Author hejiang
 * @Date 2020/7/5 10:04
 */
public class BaseStreamMiddleDemo {
    public static void main(String[] args) {
        System.out.println("----------------流的相关操作，包括：过滤器（filter）----------------------------------\n");
        streamFilter();
        System.out.println("----------------流的相关操作，包括：去重（distinct）----------------------------------\n");
        streamDistinct();
        System.out.println("----------------流的相关操作，包括：排序（sorted）----------------------------------\n");
        streamSorted();
        System.out.println("----------------流的相关操作，包括：限制（limit），跳过（skip）----------------------------------\n");
        streamLimitSkip();
        System.out.println("----------------流的相关操作，包括：元素映射（map）----------------------------------\n");
        streamMap();
        System.out.println("----------------流的相关操作，包括：映射（flatMap）----------------------------------\n");
        streamFlatMap();
    }

    /**
     * 流的相关操作，包括：过滤器（filter）
     * 过滤器（filter）:将流中满足要求条件的元素保留，剔除不满足条件的元素
     */
    private static void streamFilter() {
        Stream<Person> s = Data.getData().stream();

        //保留流中成绩 >= 80的成员
        s.filter(ele -> ele.getScore() >= 80).forEach(System.out::println);
    }

    /**
     * 流的相关操作，包括：去重（distinct）
     * 去重（distinct）:去除集合中重复的元素
     * 去重规则：
     * 1. 先判断hashCode()
     * 2. 如果hashCode()相同，再判断equals()
     */
    private static void streamDistinct() {
        Stream<Person> s = Data.getData().stream();

        s.distinct().forEach(System.out::println);
    }

    /**
     * 流的相关操作，包括：排序（sorted）
     * 排序（sorted）:对流的元素进行排序
     */
    private static void streamSorted() {
        Stream<Person> s = Data.getData().stream();
        //对流中的数据按分数进行升序排序
        //比较  有3种写法
//        s.sorted((n1, n2) -> n1.getScore() - n2.getScore()).forEach(System.out::println);
        //下面这种方式sorted()有参数
//        s.sorted(Comparator.comparing(Person::getScore)).forEach(System.out::println);
        //下面这种方式sorted()无参数，需要在实体类（本项目是Person）中实现Comparable接口
        s.sorted().forEach(System.out::println);
    }

    /**
     * 流的相关操作，包括：限制（limit），跳过（skip）
     * 限制（limit）:截断流中的数据，只取流中前指定位结束的元素
     * 跳过（skip）：跳过前指定位，只取流中指定位之后的元素
     */
    private static void streamLimitSkip() {
        Stream<Person> s = Data.getData().stream();

        //只取流中前3位的元素
//        System.out.println("limit->>>");
//        s.limit(3).forEach(System.out::println);

        //跳过前3位元素
//        System.out.println("skip->>>");
//        s.skip(3).forEach(System.out::println);

        //取流中3-6位元素
        System.out.println("limit&skip->>>");
        s.limit(6).skip(3).forEach(System.out::println);
    }

    /**
     * 流的相关操作，包括：元素映射（map）
     * 元素映射（map）:用指定元素来替换流中的元素，指定元素可以和流中的元素类型不一样
     */
    private static void streamMap() {
        Stream<Person> s = Data.getData().stream();

        //将流中的Person对象替换成为他们的名字
        //有两种写法
//        s.map(Person::getName).forEach(System.out::println);
//        s.map(ele -> ele.getName()).forEach(System.out::println);

        //将成绩大于等于80的，替换成为他们的名字
        s.map(ele -> ele.getScore() >= 80 ? ele.getName() : ele).forEach(System.out::println);
    }

    /**
     * 流的相关操作，包括：映射（flatMap）
     * 映射（flatMap）:将流的数组中的元素取出来，替换原来流中的元素
     */
    private static void streamFlatMap() {
        String[] array = {"hello", "world"};

        //将s流中的字符取出来生成一个新的流
        List<String> list = Arrays.stream(array).map(ele -> ele.split("")).
                flatMap(Arrays::stream).
                collect(Collectors.toList());
        System.out.println(list);
    }
}
