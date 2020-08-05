package com.java.learn.design.mode.principle.dip.entity;

/**
 * 顾客
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class Customer {
    public void shopping(Shop shop){
        System.out.println(shop.sell());
    }
}
