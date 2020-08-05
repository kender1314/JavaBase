package com.java.learn.design.mode.principle.lod.demo;

import com.java.learn.design.mode.principle.lod.entity.Agent;
import com.java.learn.design.mode.principle.lod.entity.Company;
import com.java.learn.design.mode.principle.lod.entity.Fans;
import com.java.learn.design.mode.principle.lod.entity.Star;

/**
 * 迪米特法则又叫作最少知识原则
 * 定义：如果两个软件实体无须直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用。其目的是降低类之间的耦合度，提高模块的相对独立性。
 *
 * 明星由于全身心投入艺术，所以许多日常事务由经纪人负责处理，如与粉丝的见面会，与媒体公司的业务洽淡等。
 * 这里的经纪人是明星的朋友，而粉丝和媒体公司是陌生人，所以适合使用迪米特法则
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class LoDDemo {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setMyCompany(new Company("中国传媒有限公司"));
        agent.setMyFans(new Fans("林浩洋"));
        agent.setMyStar(new Star("周深"));
        agent.meeting();
        agent.business();
    }
}
