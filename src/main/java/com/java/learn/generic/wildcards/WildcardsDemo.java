package com.java.learn.generic.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Java 泛型中通配符详解
 * 1、无边界的通配符（Unbounded Wildcards），
 * 采用 <?> 的形式，比如 List<?>，无边界的通配符的主要作用就是让泛型能够接受未知类型的数据。
 * <p>
 * 2、固定上边界的通配符（Upper Bounded Wildcards）
 * 使用固定上边界的通配符的泛型，就能够接受指定类及其子类类型的数据。要声明使用该类通配符，采用 <? extends E> 的形式，这里的 E 就是该泛型的上边界。
 * 注意：这里虽然用的是 extends 关键字，却不仅限于继承了父类 E 的子类，也可以代指实现了接口 E 的类。
 * <p>
 * 3、固定下边界的通配符（Lower Bounded Wildcards）
 * 使用固定下边界的通配符的泛型，就能够接受指定类及其父类类型的数据。要声明使用该类通配符，采用 <? super E> 的形式，这里的 E 就是该泛型的下边界。
 * 注意：你可以为一个泛型指定上边界或下边界，但是不能同时指定上下边界。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/25 14:07
 */
public class WildcardsDemo {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        List<ArrayList<String>> listInteger = new ArrayList<>();
        List<LinkedList<Integer>> listString = new ArrayList<>();
        list.add("111");
        list.add("222");
        linkedList.add(23);
        listInteger.add(list);
        listString.add(linkedList);
        printCollection(listInteger);
        printCollection(listString);
    }

    public static void printCollection(Collection<? extends List<?>> collection) {
        for (Object obj : collection) {
            System.out.println(obj);
        }
    }
}
