package com.java.learn.design.mode.bulider;

/**
 * 具体建造者：实现了抽象建造者接口。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/12 11:04
 */
public class ConcreteBuilder extends Builder{
    @Override
    public void buildPartA() {
        product.setPartA("建造 PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("建造 PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("建造 PartC");
    }
}
