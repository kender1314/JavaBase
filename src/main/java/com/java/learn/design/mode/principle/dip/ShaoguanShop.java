package com.java.learn.design.mode.principle.dip;

/**
 * 韶关网店
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class ShaoguanShop implements Shop{
    @Override
    public String sell() {
        return "韶关土特产：香菇、木耳……";
    }
}
