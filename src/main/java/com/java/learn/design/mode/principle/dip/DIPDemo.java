package com.java.learn.design.mode.principle.dip;

import lombok.extern.slf4j.Slf4j;

/**
 * ��������ԭ��
 * ���壺�߲�ģ�鲻Ӧ�������Ͳ�ģ�飬���߶�Ӧ����������󣻳���Ӧ������ϸ�ڣ�ϸ��Ӧ����������
 *
 * e.g���˿���ȥ��ͬ�ĵ���������
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
        System.out.println("�˿͹���������Ʒ��");
        wang.shopping(new ShaoguanShop());
        wang.shopping(new WuyuanShop());
    }
}
