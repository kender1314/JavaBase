package com.java.learn.design.mode.principle.isp.demo;

import com.java.learn.design.mode.principle.isp.entity.StuScoreList;
import com.java.learn.design.mode.principle.isp.interfaceJ.CountModule;
import com.java.learn.design.mode.principle.isp.interfaceJ.PerformanceModule;
import com.java.learn.design.mode.principle.isp.interfaceJ.PrintModule;

/**
 * 接口隔离原则
 * 定义：要为各个类建立它们需要的专用接口，而不要试图去建立一个很庞大的接口供所有依赖它的类去调用。
 *
 * e.g：学生成绩管理程序一般包含插入成绩、删除成绩、修改成绩、计算总分、计算均分、打印成绩信息、
 * 査询成绩信息等功能，如果将这些功能全部放到一个接口中显然不太合理，正确的做法是将它们分别放在输入模块、统计模块和打印模块等 3 个模块中
 *
 * 将上诉要求拆分为成绩管理，统计，打印三个模块
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class ISPDemo {
    public static void main(String[] args) {
        //对接口进行实例化
        CountModule countModule = StuScoreList.getCountModule();
        PerformanceModule performanceModule = StuScoreList.getPerformanceModule();
        PrintModule printModule = StuScoreList.getPrintModule();

        countModule.countAverage();
        performanceModule.insert();
        printModule.printStuInfo();
    }
}
