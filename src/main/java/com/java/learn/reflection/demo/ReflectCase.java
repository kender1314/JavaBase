package com.java.learn.reflection.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;

/**
 * 实现一个“框架”，在不修改代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意的方法。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */

public class ReflectCase {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 获取ReflectCase字节码文件的类加载器
        ClassLoader classLoader = ReflectCase.class.getClassLoader();
        //类加载中：
        // getResource就是为了获取这个类中reflectCase.properties的路径
        // getResourceAsStream是为了获取reflectCase.properties的字节流
//        InputStream resourceAsStream = classLoader.getResourceAsStream("reflectCase.properties"); //不知道什么原因，这样写会返回空指针异常
        try {
            InputStream resourceAsStream = new FileInputStream("D:\\ideaIU\\Java-Learn-Space\\JavaBase\\src\\main\\java\\com\\java\\learn\\reflection\\demo\\reflectCase.properties");
//            InputStream resourceAsStream1 = new FileInputStream("reflectCase.properties");
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取reflectCase.properties字节流中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //加载类进内存
        Class aClass = null;
        Object o = null;
        try {
            aClass = Class.forName(className);
             o = aClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        //创建对象
        Method method = null;
        try {
            method = aClass.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(o);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
