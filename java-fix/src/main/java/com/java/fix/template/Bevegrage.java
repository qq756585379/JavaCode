package com.java.fix.template;

public abstract class Bevegrage {

    public final void create() {
        //把水烧开
        boilWater();
        //把杯子、原料放到杯中
        pourInCup();
        //用水冲泡
        brew();
        //添加辅料
        addCoundiments();
    }

    public abstract void pourInCup();

    public abstract void addCoundiments();

    public void brew() {
        System.out.println("将开水放入杯中");
    }

    public void boilWater() {
        System.out.println("烧开水，烧到100度");
    }
}
