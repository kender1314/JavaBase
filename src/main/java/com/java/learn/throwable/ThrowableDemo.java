package com.java.learn.throwable;

/**
 * 获取方法执行的堆栈信息
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/13 14:01
 */
public class ThrowableDemo {

    public static void main(String[] args) {
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        String className = stackTrace[0].getClassName();
        System.out.println(className);

    }
}
