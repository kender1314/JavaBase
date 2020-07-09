package com.java.learn.reflection.entity;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/7 23:22
 * @Description:
 */
public class People {

    private String name;

    private Integer age;

    public String interest;

    public Integer score;

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public People() {
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
