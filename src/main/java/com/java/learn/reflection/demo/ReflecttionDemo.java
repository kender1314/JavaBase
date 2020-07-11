package com.java.learn.reflection.demo;

import com.java.learn.reflection.entity.People;
import com.java.learn.stream.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 * 1. 获取类对象的方式
 * 2. 根据类对象，获取类中的变量
 * 3. 根据类对象，获取类的构造方法
 * 4. 根据类对象，获取类的成员方法
 *
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
        showMethod();
    }

    /**
     * 反射的相关操作，包括：获取类对象
     * 获取类对象的方式
     * 1. Class.forName("全类名")：将字节码文件 加载进内存，返回Class对象。（全类名：包路径+类名）。（源代码阶段（Source））
     * 2. 类名.class：通过类名的属性class获取。（类对象阶段阶段（Class））
     * 3. 实例对象.getClass()：getClass()方法在Object中定义的。（运行时阶段（Runtime））
     */
    private static void getObject() {
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
    private static void showField() {
        People people = new People();
//        people.setInterestPublic("football");
        Class cls = People.class;

        System.out.println("\ngetFields获取类字段数组，只能获取public类型字段->>>\n");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        try {
            Field interest = cls.getField("interestPublic");
            System.out.println("\ngetField获取指定类字段，只能获取public类型字段->>>\n" + interest);
            //为interestPublic设置值
            interest.set(people, "football");
            Object o = interest.get(people);
            System.out.println(o);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("\ngetDeclaredFields获取类字段数组，获取所有类型字段，包括private类型->>>");
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        try {
            Field name = cls.getDeclaredField("name");
            System.out.println("\ngetDeclaredField获取指定类字段，可获取所有类型字段->>>\n" + name);
            //需要设置忽略访问权限修饰符的安全检查
            name.setAccessible(true);   //暴力反射
            name.set(people, "hejia");
            Object o = name.get(people);
            System.out.println("\ngetDeclaredField获取private字段的值->>>\n" + o);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射的相关操作，包括：根据类对象，获取类的构造方法
     * 获取构造方法或构造方法数组
     */
    private static void showConstructor() {
        Class cls = People.class;

        //可以通过类的构造方法getConstructor和Class中的newInstance方法，创建类的实例对象
        try {
            Constructor constructor = cls.getConstructor(String.class, Integer.class);
            assert constructor != null;
            Object obj = constructor.newInstance("hejina", 22);
            System.out.println(obj);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射的相关操作，包括：根据类对象，获取类的成员方法
     * 获取成员方法或成员方法数组
     */
    private static void showMethod() {
        Class cls = People.class;
        People people = new People();
        try {
            Method eat1 = cls.getMethod("eat");
            Method eat2 = cls.getMethod("eat", String.class);
            System.out.println("调用类中的指定方法->>>");
            //调用类中的指定方法
            eat1.invoke(people);
            eat2.invoke(people, "beef");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("\n获取类中所有方法，获取的还包括其父类的方法->>>");
        //获取类中所有方法
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println("获取方法名称->>>[" + method + "]---方法名称---[" + method.getName() + "]");
        }
    }
}
