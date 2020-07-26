package com.java.learn.lambda.demo;

import com.java.learn.lambda.service.NoReturnMutilParam;
import com.java.learn.lambda.service.NoReturnNoParam;
import com.java.learn.lambda.service.NoReturnOneParam;

/**
 * Lambda表达式，也可称为闭包，它是推动Java8发布的最重要的新特性。
 * Lambda允许把函数为一个方法的参数（函数作为参数传递进方法中）。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/26 19:42
 * @Description:
 */

public class LambdaDemo {
    public static void main(String[] args) {
        //传统的接口使用方式1
//        InterfaceDemo interfaceDemo = new InterfaceDemo();
//        interfaceDemo.method();

        //传统的接口使用方式2，匿名内部类
//        NoReturnNoParam noReturnNoParam = new NoReturnNoParam() {
//            @Override
//            public void method() {
//                System.out.println("没有返回值，也没有参数，匿名内部类");
//            }
//        };
//        noReturnNoParam.method();

        //lambda表达式写法1，无参数无返回值
        NoReturnNoParam noReturnNoParam1 = () -> System.out.println("没有返回值，也没有参数，lambda表示式写法");
        noReturnNoParam1.method();

        //lambda表达式写法2，一个参数无返回值
//        NoReturnOneParam noReturnOneParam = a -> {
//            System.out.println("没有返回值，有一个参数，参数是=" + a + "，lambda表示式写法");
//        };
//        noReturnOneParam.method(55);

        //lambda表达式写法3，多个参数无返回值
//        NoReturnMutilParam noReturnMutilParam = (a, b) ->{
//            System.out.println("没有返回值，有多个参数，参数1是=" + a + "，参数2是=" + a + "，lambda表示式写法");
//        };
//        noReturnMutilParam.method(5, 10);
    }

    static class InterfaceDemo implements NoReturnNoParam{

        @Override
        public void method() {
            System.out.println("没有返回值，也没有参数");
        }
    }
}
