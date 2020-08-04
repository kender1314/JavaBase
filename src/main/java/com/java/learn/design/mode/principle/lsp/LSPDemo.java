package com.java.learn.design.mode.principle.lsp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 里氏替换原则
 * <p>
 * 定义：里氏替换原则主要阐述了有关继承的一些原则，也就是什么时候应该使用继承，什么时候不应该使用继承，
 * 以及其中蕴含的原理。里氏替换原是继承复用的基础，它反映了基类与子类之间的关系，是对开闭原则的补充，是对实现抽象化的具体步骤的规范
 * <p>
 * 问题：鸟一般都会飞行，如燕子的飞行速度大概是每小时 120 千米。
 * 但是新西兰的几维鸟由于翅膀退化无法飞行。假如要设计一个实例，
 * 计算这两种鸟飞行 300 千米要花费的时间。显然，拿燕子来测试这段代码，
 * 结果正确，能计算出所需要的时间；但拿几维鸟来测试，结果会发生“除零异常”或是“无穷大”，明显不符合预期
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class LSPDemo {
    private static Logger logger = LoggerFactory.getLogger(LSPDemo.class);

    public static void main(String[] args) {
        Bird swallow = new Swallow();
        Bird brownKiwi = new BrownKiwi();

        brownKiwi.setSpeed(120);
        swallow.setSpeed(120);
        System.out.println("如果飞行300公里：");
        try {
            double time1 = brownKiwi.getFlyTime(300);
            double time2 = swallow.getFlyTime(300);
            System.out.println("燕子飞了" + time2 + "小时");
            System.out.println("几维鸟飞了" + time1 + "小时");
        } catch (Exception e) {
            logger.info("发生错误了!");
        }
    }
}
