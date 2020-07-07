package com.java.learn.Enum.demo;

import netscape.javascript.JSObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/6 22:24
 * @Description:
 */

public class EnumDemo {
    public static void main(String[] args) {

        Map<EnumTest, Map<String, JSObject>> mapMap = new HashMap<>(5);
        Map<String, JSObject> map = new HashMap<>();
        for (EnumTest enumTest : EnumTest.values()) {
            EnumTest test = enumTest.setTmp(enumTest.getUrl() + "aaa");
            mapMap.put(test, map);
        }
        List<String> list = mapMap.keySet().stream().map(EnumTest::getTmp).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     *
     */
    public enum EnumTest {
        //
        EE1("1"),
        EE2("2"),
        EE3("3");

        private String url;

        private String tmp;

        EnumTest(String url) {
            this.url = url;
        }

        public String getTmp() {
            return tmp;
        }

        public EnumTest setTmp(String tmp) {
            this.tmp = tmp;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public EnumTest setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
