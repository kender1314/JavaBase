package com.java.learn.design.mode.singleton.demo;

import com.java.learn.design.mode.singleton.entity.Bajie;
import com.java.learn.design.mode.singleton.entity.President;

/**
 * 单例模式
 * 定义：指一个类只有一个实例，且该类能自行创建这个实例的一种模式。例如，Windows 中只能打开一个任务管理器，
 * 这样可以避免因打开多个任务管理器窗口而造成内存资源的浪费，或出现各个窗口显示内容的不一致等错误。
 * e.g：
 *   1.用懒汉式单例模式模拟产生美国当今总统对象。
 *   2.用饿汉式单例模式模拟产生猪八戒对象。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@SuppressWarnings("all")
public class Singleton {
    public static void main(String[] args) {
        //用懒汉式单例模式模拟产生美国当今总统对象。
//        lazyPresident();
        //用饿汉式单例模式模拟产生猪八戒对象。
        hungryBajie();
    }

    private static void lazyPresident() {
        President president1 = President.getInstance();
        president1.getName();
        President president2 = President.getInstance();
        president2.getName();

        if (president1 == president2){
            System.out.println("他们是同一个人！");
        }else {
            System.out.println("他们不是同一人！");
        }
    }
    private static void hungryBajie(){
        Bajie bajie1 = Bajie.getInstance();
        bajie1.getName();
        Bajie bajie2 = Bajie.getInstance();
        bajie2.getName();

        if (bajie1 == bajie2){
            System.out.println("它们是同一头猪！");
        }else {
            System.out.println("它们不是同一头猪！");
        }
    }
}
