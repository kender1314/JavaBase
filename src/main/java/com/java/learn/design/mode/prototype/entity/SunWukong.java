package com.java.learn.design.mode.prototype.entity;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class SunWukong implements Cloneable {
    private static final long serialVersionUID = 5543049531872119328L;

    public SunWukong() {
        System.out.println("我是孙悟空！");
    }

    public Object clone() {
        SunWukong sunWukong = null;
        try {
            sunWukong = (SunWukong) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝悟空失败!");
        }
        return sunWukong;
    }
}
