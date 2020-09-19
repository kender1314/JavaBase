package com.java.learn.design.principle.isp.entity;

import com.java.learn.design.principle.isp.interfaceJ.CountModule;
import com.java.learn.design.principle.isp.interfaceJ.PerformanceModule;
import com.java.learn.design.principle.isp.interfaceJ.PrintModule;

/**
 * 同一个类可以实现多个接口，但是接口要实现的功能一定要单一
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class StuScoreList implements CountModule, PerformanceModule, PrintModule {
    private StuScoreList(){

    }

    public static PerformanceModule getPerformanceModule(){
        return new StuScoreList();
    }

    public static CountModule getCountModule(){
        return new StuScoreList();
    }
    
    public static PrintModule getPrintModule(){
        return new StuScoreList();
    }

    public void insert() {
        System.out.println("成绩管理模块的insert()方法被调用！");
    }

    public void delete() {
        System.out.println("成绩管理模块的delete()方法被调用！");
    }

    public void modify() {
        System.out.println("成绩管理模块的modify()方法被调用！");
    }

    public void countTotalScore() {
        System.out.println("统计模块的countTotalScore()方法被调用！");
    }

    public void countAverage() {
        System.out.println("统计模块的countAverage()方法被调用！");
    }

    public void printStuInfo() {
        System.out.println("打印模块的printStuInfo()方法被调用！");
    }

    public void queryStuInfo() {
        System.out.println("打印模块的queryStuInfo()方法被调用！");
    }
}
