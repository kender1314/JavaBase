package com.java.learn.design.mode.principle.srp.demo;

import com.java.learn.design.mode.principle.srp.entity.TeacherForLife;
import com.java.learn.design.mode.principle.srp.entity.TeacherForTeach;
import lombok.extern.slf4j.Slf4j;

/**
 * 单一职责原则
 * 定义：一个类应该有且仅有一个引起它变化的原因，否则类应该被拆分
 *
 * e.g: 大学学生工作主要包括学生生活辅导和学生学业指导两个方面的工作，其中生活辅导主要包括班委建设、
 * 出勤统计、心理辅导、费用催缴、班级管理等工作，学业指导主要包括专业引导、学习辅导、科研指导、
 * 学习总结等工作。如果将这些工作交给一位老师负责显然不合理，正确的做 法是生活辅导由辅导员负责，学业指导由学业导师负责，
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Slf4j
public class SRPDemo {
    public static void main(String[] args) {
        TeacherForLife teacherForLife = new TeacherForLife();
        TeacherForTeach teacherForTeach = new TeacherForTeach();

        teacherForLife.attendanceStatistics();
        teacherForTeach.professionalGuidance();
    }
}
