package com.java.learn.lambda.service;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/26 19:25
 * @Description:
 */
@FunctionalInterface
public interface NoReturnMutilParam {
    void method(int a, int b);

    default void defaultMethod(){}
}
