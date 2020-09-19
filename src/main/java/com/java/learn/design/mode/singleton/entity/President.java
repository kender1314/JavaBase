package com.java.learn.design.mode.singleton.entity;

/**
 * 用懒汉式单例模式模拟产生美国当今总统对象。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class President {

    private static volatile President instance = null;

    private President(){
        System.out.println("产生一个总统！");
    }

    public static synchronized President getInstance(){
        if (instance == null){
            instance = new President();
        }else {
            System.out.println("已经有一个总统了，不能产生新总统！");
        }
        return instance;
    }

    public void getName(){
        System.out.println("I am trump！");
    }
}
