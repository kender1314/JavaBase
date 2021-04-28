package com.java.learn.clone;

import org.apache.commons.lang.SerializationUtils;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CloneDemo {
    public static void main(String[] args) {
        clone3();
    }

    public static void clone1(){
        ConcurrentHashMap<String, String> original = new ConcurrentHashMap<>(5);
        original.put("hello", "Salaam");
        Map<String, String> copy = new ConcurrentHashMap<>(original);
        original.remove("hello");
        System.out.println(copy.get("hello"));
    }

    public static void clone2(){
        List<String> list = new ArrayList<>();
        ConcurrentHashMap<String, List<String>> original = new ConcurrentHashMap<>(5);
        list.add("11");
        list.add("22");
        list.add("33");
        original.put("a", list);
        ConcurrentHashMap<String, List<String>> copy = new ConcurrentHashMap<>(original);
        System.out.println("第一次打印：" + copy);
        list.add("44");
        System.out.println("第二次打印：" + copy);
    }

    public static void clone3(){
        List<String> list = new ArrayList<>();
        ConcurrentHashMap<String, List<String>> original = new ConcurrentHashMap<>(5);
        list.add("11");
        list.add("22");
        list.add("33");
        original.put("a", list);
        ConcurrentHashMap<String, List<String>> copy = (ConcurrentHashMap<String, List<String>>)SerializationUtils.clone(original);
        System.out.println("第一次打印：" + copy);
        list.add("44");
        System.out.println("第二次打印：" + copy);
    }
}
