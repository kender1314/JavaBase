package com.java.learn.annotation;

public @interface MyTag {
    // 定义带两个成员变量的注解
    // 注解中的成员变量以方法的形式来定义
    String name();
    int age();
}
