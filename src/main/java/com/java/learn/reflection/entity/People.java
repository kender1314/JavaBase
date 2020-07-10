package com.java.learn.reflection.entity;

import java.util.Date;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/7 23:22
 * @Description:
 */
public class People {

    private String name;

    private Integer age;

    public String interestPublic;

    public Integer scorePublic;

    protected Date birthProtected;

    String addressDefault;

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public People() {
    }

    public People(String name, Integer age, String interestPublic, Integer scorePublic, Date birthProtected, String addressDefault) {
        this.name = name;
        this.age = age;
        this.interestPublic = interestPublic;
        this.scorePublic = scorePublic;
        this.birthProtected = birthProtected;
        this.addressDefault = addressDefault;
    }

    public String getInterestPublic() {
        return interestPublic;
    }

    public void setInterestPublic(String interestPublic) {
        this.interestPublic = interestPublic;
    }

    public Integer getScorePublic() {
        return scorePublic;
    }

    public void setScorePublic(Integer scorePublic) {
        this.scorePublic = scorePublic;
    }

    public Date getBirthProtected() {
        return birthProtected;
    }

    public void setBirthProtected(Date birthProtected) {
        this.birthProtected = birthProtected;
    }

    public String getAddressDefault() {
        return addressDefault;
    }

    public void setAddressDefault(String addressDefault) {
        this.addressDefault = addressDefault;
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

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", interestPublic='" + interestPublic + '\'' +
                ", scorePublic=" + scorePublic +
                ", birthProtected=" + birthProtected +
                ", addressDefault='" + addressDefault + '\'' +
                '}';
    }
}
