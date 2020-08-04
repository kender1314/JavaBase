package com.java.learn.design.mode.principle.lsp;

/**
 * 鸟类
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class Bird {
    double flySpeed;

    public void setSpeed(double speed) {
        this.flySpeed = speed;
    }

    public double getFlyTime(double distance){
        return (distance/flySpeed);
    }
}
