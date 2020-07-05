package com.java.learn.stream.demo;

import com.java.learn.stream.entity.Data;
import com.java.learn.stream.entity.Person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 需求：一个集合中存储了若干个Person对象，要求查出以下结果
 * 1. 所有及格的学生信息
 * 2. 所有及格的学生姓名
 * 3. 成绩在班级前3名的学生信息
 * 4. 成绩在班级3-10名的学生成绩
 * 5. 所有不及格的学生的平均成绩
 * 6. 将及格学生，按照成绩降序输出所有信息
 * 7. 班级学生的总分
 *
 * @ClassName BaseStreamExerciseDemo
 * @Description TODO
 * @Author hejiang
 * @Date 2020/7/5 13:00
 */
public class BaseStreamExerciseDemo {
    public static void main(String[] args) {
        System.out.println("所有及格的学生信息");
        exercise1();
        System.out.println("所有及格的学生姓名");
        exercise2();
        System.out.println("成绩在班级前3名的学生信息");
        exercise3();
        System.out.println("成绩在班级3-10名的学生成绩");
        exercise4();
        System.out.println("所有不及格的学生的平均成绩");
        exercise5();
        System.out.println("将及格学生，按照成绩降序输出所有信息");
        exercise6();
        System.out.println("班级学生的总分");
        exercise7();
    }

    private static void exercise1() {
        Stream<Person> s = Data.getData().stream();

        List<Person> list = s.filter(n1 -> n1.getScore() >= 60).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void exercise2() {
        Stream<Person> s = Data.getData().stream();

        List<String> list = s.filter(n1 -> n1.getScore() >= 60).map(Person::getName).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void exercise3() {
        Stream<Person> s = Data.getData().stream();

        List<Person> list = s.sorted((n1, n2) -> n2.getScore() - n1.getScore()).limit(3).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void exercise4() {
        Stream<Person> s = Data.getData().stream();

        List<Person> list = s.sorted((n1, n2) -> n2.getScore() - n1.getScore()).limit(10).skip(3).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void exercise5() {
        Person person = new Person();
        Optional<Person> sum = Data.getData().stream().filter(ele -> ele.getScore() < 60).
                reduce((n1, n2) -> person.setScore(n1.getScore() + n2.getScore()));

        long count = Data.getData().stream().filter(ele -> ele.getScore() < 60).count();
        System.out.println((float) person.getScore()/count);
    }

    private static void exercise6() {
        List<Person> list = Data.getData().stream().sorted((n1, n2) -> n2.getScore() - n1.getScore()).
                filter(ele -> ele.getScore()>=60).collect(Collectors.toList());

        System.out.println(list);
    }

    private static void exercise7() {
        Person person = new Person();
        Data.getData().stream().reduce((n1, n2) -> person.setScore(n1.getScore() + n2.getScore()));
        System.out.println(person.getScore());
    }
}
