package com.java.learn.telnet;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class TestInputStream {
    public static void main(String args[]) throws IOException {
        System.out.println(System.currentTimeMillis()/1000);
        InputStream in = System.in;
        int a = in.read();
        System.out.println("1-->:" + a);
        a = in.read();
        System.out.println("2-->:" + a);
        a = in.read();
        System.out.println("3-->:" + a);
    }

}
