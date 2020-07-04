package com.java.learn.stream.entity;

/**
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/4 20:11
 * @Description:
 */

public class Person {
    private String name;
    private int age;
    private int score;

    public Person() {
    }

    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Person setScore(int score) {
        this.score = score;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
