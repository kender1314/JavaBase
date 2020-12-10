package com.java.learn.sqlinjection;

/**
 * 防止sql注入
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/12/10 10:14
 */
public class SqlInj {
    public static void main(String[] args) {

    }

    public static String transactSQLInjection(String sql){
        return sql.replaceAll(".*([';]+|(--)+).*", " ");
    }
}
