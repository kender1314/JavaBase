package com.java.learn.stream.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/4 20:33
 * @Description:
 */

public class Data {
    public static List<Person> getData(){
        List<Person> list = new ArrayList<>(5);

        list.add(new Person("xiaoming", 10, 50));
        list.add(new Person("xiaohui", 11, 60));
        list.add(new Person("xiaowang", 12, 30));
        list.add(new Person("xiaoli", 13, 90));
        list.add(new Person("xiaozhang", 14, 70));
        list.add(new Person("xiaoyue", 15, 80));
        list.add(new Person("xiaotang", 16, 40));
        list.add(new Person("xiaowu", 17, 55));
        list.add(new Person("xiaowu", 17, 55));
        list.add(new Person("xiaohua", 18, 30));

        return list;
    }
}
