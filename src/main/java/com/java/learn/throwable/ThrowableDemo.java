package com.java.learn.throwable;

import java.io.IOException;

/**
 * 获取方法执行的堆栈信息
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/13 14:01
 */
public class ThrowableDemo {

    public static void main(String[] args) {
//        Throwable throwable = new Throwable();
//        StackTraceElement[] stackTrace = throwable.getStackTrace();
//        String className = stackTrace[0].getClassName();
//        System.out.println(className);
        System.out.println(inc());
    }

    public static int inc() {
        int x;
        try {
            int i = 1 / 0;
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
