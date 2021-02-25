package com.java.learn.generic.demo;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/25 11:15
 */
public class TestDemo {
    public static void main(String[] args) throws ClassNotFoundException {
//        Generic<Object> generic = new Generic<>();

        GenericObj<Generic<Object>> genericObj = new GenericObj(Class.forName("com.java.learn.generic.demo.Generic"));
        Generic<Object> generic1 = genericObj.obj;

        generic1.setData(1111);
        System.out.println(generic1.getRes("qaAAAdddd"));

        System.out.println(generic1.getData());
    }
}
