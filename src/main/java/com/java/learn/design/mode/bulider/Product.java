package com.java.learn.design.mode.bulider;

/**
 * 产品角色：包含多个组成部件的复杂对象。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/12 10:58
 */
public class Product {
    private String partA;
    private String partB;
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        //显示产品的特性
        System.out.println("partB: " + partB);
    }

}
