package com.java.learn.design.mode.principle.dip;

/**
 * 婺源网店
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class WuyuanShop implements Shop{
    @Override
    public String sell() {
        return "婺源土特产：绿茶、酒糟鱼……";
    }
}
