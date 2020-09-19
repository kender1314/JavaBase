package com.java.learn.design.principle.lod.entity;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class Agent {
    private Star myStar;
    private Fans myFans;
    private Company myCompany;

    public void setMyStar(Star myStar) {
        this.myStar = myStar;
    }

    public void setMyFans(Fans myFans) {
        this.myFans = myFans;
    }

    public void setMyCompany(Company myCompany) {
        this.myCompany = myCompany;
    }

    public void meeting(){
        System.out.println(myStar.getName() + "与粉丝" + myFans.getName() + "见面。");
    }

    public void business(){
        System.out.println(myStar.getName() + "与媒体公司" + myCompany.getName() + "洽谈业务。");
    }

}
