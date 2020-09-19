package com.java.learn.design.mode.singleton.entity;

/**
 * 用饿汉式单例模式模拟产生猪八戒对象。
 * <p>
 * <p>
 * 同上例类似，猪八戒也只有一个，所以本实例同样适合用单例模式实现。
 * 本实例由于要显示猪八戒的图像（点此下载该程序所要显示的猪八戒图片），
 * 所以用到了框架窗体 JFrame 组件，这里的猪八戒类是单例类，可以将其定义成面板 JPanel 的子类，
 * 里面包含了标签，用于保存猪八戒的图像，客户窗体可以获得猪八戒对象，并显示它。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class Bajie {
    private static final Bajie instance = new Bajie();

    private Bajie() {
        System.out.println("我是八戒！");
    }

    public static Bajie getInstance(){
        return instance;
    }

    public void getName(){
        System.out.println("我的名字是猪八戒！");
    }
}
