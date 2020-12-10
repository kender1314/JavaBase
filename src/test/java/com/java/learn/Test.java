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
        String s = "{\n" +
                "\t\"from\": 0,\n" +
                "\t\"size\": 0,\n" +
                "\t\"query\": {\n" +
                "\t\t\"bool\": {\n" +
                "\t\t\t\"must\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"query_string\": {\n" +
                "\t\t\t\t\t\t\"analyze_wildcard\": true,\n" +
                "\t\t\t\t\t\t\"query\": \"*\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"range\": {\n" +
                "\t\t\t\t\t\t\"date\": {\n" +
                "\t\t\t\t\t\t\t\"gte\": \"2020-11-03 00:00:00\",\n" +
                "\t\t\t\t\t\t\t\"lte\": \"2020-12-02 23:59:59\"\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"must_not\": []\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"_source\": {\n" +
                "\t\t\"excludes\": [\n" +
                "\t\t\t\"@timestamp\",\n" +
                "\t\t\t\"link_id\"\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t\"aggs\": {\n" +
                "\t\t\"ip2\": {\n" +
                "\t\t\t\"terms\": {\n" +
                "\t\t\t\t\"field\": \"ip2\",\n" +
                "\t\t\t\t\"size\": 10\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t\"ip1\": {\n" +
                "\t\t\t\"terms\": {\n" +
                "\t\t\t\t\"field\": \"ip2\",\n" +
                "\t\t\t\t\"size\": 10\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"fields\": [\n" +
                "\t\t\"*\",\n" +
                "\t\t\"_source\"\n" +
                "\t],\n" +
                "\t\"fielddata_fields\": [\n" +
                "\t\t\"e_date\",\n" +
                "\t\t\"s_date\",\n" +
                "\t\t\"create_date\",\n" +
                "\t\t\"date\"\n" +
                "\t]\n" +
                "}";
//            String s = "{\"name\":[1, 2]}";
        JSONObject json = (JSONObject) JSONObject.parse(s);
        System.out.println(!json.getString("bool").equals("true"));
    }

}
