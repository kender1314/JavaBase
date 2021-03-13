package com.java.learn.design.mode.bulider;

/**
 * 客户类。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/12 11:08
 */
public class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product construct = director.construct();
        construct.show();
    }
}
