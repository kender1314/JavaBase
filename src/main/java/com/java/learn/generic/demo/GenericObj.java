package com.java.learn.generic.demo;

/**
 * 使用反射创建一个泛型对象
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/25 13:17
 */
public class GenericObj <T>{
    public T obj;

    public GenericObj(Class<T> c) {
        try {
            // 利用反射创建实例
            obj = c.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
