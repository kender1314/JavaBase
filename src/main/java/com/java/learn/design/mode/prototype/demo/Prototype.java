package com.java.learn.design.mode.prototype.demo;

import com.java.learn.design.mode.prototype.entity.Realizetype;
import com.java.learn.design.mode.prototype.entity.SunWukong;

/**
 * 原型模式
 * 定义：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，根本无须知道对象创建的细节。
 * <p>
 * e.g:用原型模式模拟“孙悟空”复制自己。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        //克隆原理
        getRealizetype();
        //用原型模式模拟“孙悟空”复制自己。
        getSunWukong();
    }

    private static void getRealizetype() throws CloneNotSupportedException {
        Realizetype realizetype1 = new Realizetype();
        Realizetype realizetype2 = (Realizetype) realizetype1.clone();

        System.out.println("realizetype1==realizetype2?" + (realizetype1 == realizetype2));
    }

    private static void getSunWukong() {
        SunWukong sunWukong1 = new SunWukong();
        SunWukong sunWukong2 = (SunWukong) sunWukong1.clone();
        System.out.println("sunWukong1==sunWukong2?" + (sunWukong1 == sunWukong2));
    }
}
