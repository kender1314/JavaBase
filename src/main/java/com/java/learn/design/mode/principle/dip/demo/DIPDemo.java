package com.java.learn.design.mode.principle.dip.demo;

import com.java.learn.design.mode.principle.dip.entity.Customer;
import com.java.learn.design.mode.principle.dip.entity.ShaoguanShop;
import com.java.learn.design.mode.principle.dip.entity.WuyuanShop;
import lombok.extern.slf4j.Slf4j;

/**
 * 依赖倒置原则
 * 定义：高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象
 *
 * e.g：顾客想去不同的店里面买东西
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Slf4j
public class DIPDemo {
    public static void main(String[] args) {
        Customer wang=new Customer();

        System.out.println("顾客购买以下商品：");
        wang.shopping(new ShaoguanShop());
        wang.shopping(new WuyuanShop());
    }
}
