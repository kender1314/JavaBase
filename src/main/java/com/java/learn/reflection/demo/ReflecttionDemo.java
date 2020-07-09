package com.java.learn.reflection.demo;

import com.java.learn.reflection.entity.People;

import java.lang.reflect.Field;

/**
 * 反射
 * 1. 获取类对象的方式
 * 2. 根据类对象，获取类中的变量
 * 3. 根据类对象，获取类的构造方法
 * 4. 根据类对象，获取类的成员方法
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/6 22:24
 * @Description:
 */

public class ReflecttionDemo {

    public static void main(String[] args) {
        System.out.println("----------------反射的相关操作，包括：获取类对象----------------------------------\n");
        getObject();
        System.out.println("----------------反射的相关操作，包括：根据类对象，获取类中的变量----------------------------------\n");
        showField();
        System.out.println("----------------反射的相关操作，包括：根据类对象，获取类的构造方法----------------------------------\n");
        showConstructor();
        System.out.println("----------------反射的相关操作，包括：根据类对象，获取类的成员方法----------------------------------\n");
        showConstructor();
    }

    /**
     * 反射的相关操作，包括：获取类对象
     * 获取类对象的方式
     * 1. Class.forName("全类名")：将字节码文件 加载进内存，返回Class对象。（全类名：包路径+类名）。（源代码阶段（Source））
     * 2. 类名.class：通过类名的属性class获取。（类对象阶段阶段（Class））
     * 3. 实例对象.getClass()：getClass()方法在Object中定义的。（运行时阶段（Runtime））
     */
    private static void getObject(){
        //Class.forName("全类名")
        Class cls1 = null;
        try {
            cls1 = Class.forName("com.java.learn.reflection.entity.People");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("全类名->>>" + cls1);

        //类名.class
        Class cls2 = People.class;
        System.out.println("类名.class->>>" + cls2);

        //实例对象.getClass()
        People people = new People();
        Class cls3 = people.getClass();
        System.out.println("实例对象.getClass()->>>" + cls1);

        //因为针对的都是字节码文件（People.class）,所以指向的都是同一个对象
        //结论：在一次程序运行过程中，同一个字节码文件，只会被加载一次，不管你用什么方式将该类加载进入内存，获取到的Class对象，都是同一个
        System.out.println(cls1.hashCode() == cls2.hashCode());
        System.out.println(cls2.hashCode() == cls3.hashCode());

        //获取所有的成员变量
        System.out.println(cls1.getFields());
    }

    /**
     * 反射的相关操作，包括：根据类对象，获取类中的变量
     * 获取成员变量或变量数组
     */
    private static void showField(){
        Class cls = People.class;

        System.out.println("获取类字段数组，只能获取public类型字段->>>");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        try {
            Field interest = cls.getField("interest");
            System.out.println("获取指定类字段，只能获取public类型字段->>>" + interest);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("获取类字段数组，获取所有类型字段->>>");
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        try {
            Field interest = cls.getDeclaredField("name");
            System.out.println("获取指定类字段，可获取所有类型字段->>>" + interest);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射的相关操作，包括：根据类对象，获取类的构造方法
     * 获取构造方法或构造方法数组
     */
    private static void showConstructor(){

    }

    /**
     * 反射的相关操作，包括：根据类对象，获取类的成员方法
     * 获取成员方法或成员方法数组
     */
    private static void showMethod(){

    }
}
