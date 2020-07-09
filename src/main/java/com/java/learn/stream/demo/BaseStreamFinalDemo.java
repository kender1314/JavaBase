package com.java.learn.stream.demo;

import com.java.learn.stream.entity.Data;
import com.java.learn.stream.entity.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * BaseStreamFinalDemo包含流的最终操作
 * 1. 集合的流式操作：JAVA8的新特性
 * 2. 流：不是一个数据结构，不负责任何的数据存储
 * 3. 更像是一个迭代器，有序获取数据源中的每一个数据，并且对这些数据进行一些操作
 * 4. 流式操作的每一个方法，都是返回流的本身
 * 5. 在流的最终操作中，流在操作之后就已经被关闭了，如果再想对这个流进行操作，需要对流重新实例化
 *
 * BaseStreamFinalDemo类包含：
 * 1. 流转换成为各种集合collect()
 * 2. 求和reduce()
 * 3. 寻找最大max()和最小值min()
 * 4. 匹配（anyMatch， allMatch， noneMatch）
 * 5. 求流中的数据总数count()
 * 6. foreach
 * 7.
 *
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/4 20:14
 * @Description:
 */

public class BaseStreamFinalDemo {
    public static void main(String[] args) {
        streamPrinciple();
        System.out.println("----------------流转换成为各种集合----------------------------------");
        streamToCollect();
        System.out.println("----------------流的相关操作，包括：求和----------------------------------");
        streamSum();
        System.out.println("----------------流的相关操作，包括：寻找最大和最小值----------------------------------");
        streamMinMax();
        System.out.println("----------------流的相关操作，包括：匹配（anyMatch， allMatch， noneMatch）----------------------------------");
        streamMatch();
        System.out.println("----------------流的相关操作，包括：求流中的数据个数----------------------------------");
        streamCount();
        System.out.println("----------------流的相关操作，包括：foreach----------------------------------");
        streamForeach();
    }

    /**
     * 流式操作原理：可以拿着每一步操作的结果去执行其他操作，比如像下面这个例子一样，在赋值的结果中还可以赋值
     */
    private static void streamPrinciple() {
        //        Person person = new Person("xiaoming", 10, 100);
        Person person = new Person();

        person.setAge(10).setName("xiaoming").setScore(20);
        System.out.println(person.toString());
    }

    /**
     * 流转换成为各种集合操作
     */
    private static void streamToCollect() {
        //获取数据源方式一
        Stream<Person> stream = Data.getData().stream();
        //获取数据源方式二
//        Stream.of(Data.getData());

        //将流中的数据转换成为一个List集合
//        List<Person> streamList = stream.collect(Collectors.toList());
//        System.out.println("List->>>" + streamList);

        //将流中的数据转换成为一个Set集合
//        Set<Person> set = stream.collect(Collectors.toSet());
//        System.out.println("Set->>>" + set);

        //将流中的数据转换成为一个Map集合，映射的键值对为（姓名：年龄）
//        Map<String, Integer> map = stream.collect(Collectors.toMap(ele -> ele.getName(), ele -> ele.getAge()));
        Map<String, Integer> map = stream.collect(Collectors.toMap(Person::getName, Person::getAge, (n1, n2) -> n1));
        System.out.println("Map->>>" + map);
    }

    /**
     * 流的相关操作，包括：求和
     */
    private static void streamSum() {
        Stream<Integer> stream = Stream.of(1, 5, 23, 65, 42, 63);
        //因为reduce可能返回为null，Optional可以接收空值, 使用sum实现求和
        Optional<Integer> sum = stream.reduce(Integer::sum);
        System.out.println("sum->>>" + sum.get());

        //所有人的分数求和
        Stream<Person> s = Data.getData().stream();
        Person person = new Person();
        Optional<Person> sumScore = s.reduce((n1, n2) -> person.setScore((n1.getScore() + n2.getScore())));
        System.out.println("sum score->>>" + sumScore.get().getScore());
    }

    /**
     * 流的相关操作，包括：寻找最大和最小值
     */
    private static void streamMinMax() {
        Stream<Person> s = Data.getData().stream();
        //找到流中成绩最高的人的信息
        //两种写法
//        Optional<Person> maxScore = s.max((n1, n2) -> n1.getScore() - n2.getScore());
//        Optional<Person> maxScore = s.max(Comparator.comparingInt(Person::getScore));
//        System.out.println("max score->>>" + maxScore.get().getScore());

        //找到流中成绩最低的人的信息
        Optional<Person> minScore = s.min(Comparator.comparingInt(Person::getScore));
        System.out.println("min score->>>" + minScore.get().getScore());

    }

    /**
     * 流的相关操作，包括：匹配（anyMatch， allMatch， noneMatch）
     * anyMatch：流中是否包含指定条件的元素，是则返回true
     * allMatch：流中所有元素都要包含指定条件的元素，是则返回true
     * noneMatch：流中所有元素都不满足指定条件，是则返回true
     */
    private static void streamMatch() {
        Stream<Person> s = Data.getData().stream();

        //判断流中是否包含成绩不及格的成员
//        boolean anyMatchFlag = s.anyMatch(n -> n.getScore() < 60);
//        System.out.println("anyMatchFlag->>>" + anyMatchFlag);

        //判断流中是否所有成员成绩 >= 30
//        boolean allMatchFlag = s.allMatch(n -> n.getScore() >= 30);
//        System.out.println("allMatchFlag->>>" + allMatchFlag);

        //判断流中是否所有成员成绩 < 30
        boolean noneMatchFlag = s.noneMatch(n -> n.getScore() < 30);
        System.out.println("noneMatchFlag->>>" + noneMatchFlag);
    }

    /**
     * 流的相关操作，包括：求流中的数据总数
     */
    private static void streamCount() {
        Stream<Person> s = Data.getData().stream();

        long count = s.count();
        System.out.println("count->>>" + count);
    }


    /**
     * 流的相关操作，包括：foreach
     */
    private static void streamForeach() {
        Stream<Person> s = Data.getData().stream();

        s.forEach(e -> System.out.println(e.getName()));
    }
}
