package com.java.learn.design.mode.bulider;

/**
 * 抽象建造者：包含创建产品各个子部件的抽象方法。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/12 10:58
 */
public abstract class Builder {
    protected Product product = new Product();
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    public Product getProduct(){
        return product;
    }
}
