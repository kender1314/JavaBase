package com.java.learn;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        String s = "{\"name\":\"jiang\"}";
//            String s = "{\"name\":[1, 2]}";
        JSONObject json = (JSONObject) JSONObject.parse(s);
        System.out.println(json.getJSONObject("22") == null);
    }

}
