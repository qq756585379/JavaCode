package com.java.fix.prototype.simple;

import java.util.ArrayList;

/**
 * 原型模式
 */
public class ConcretePrototype implements Cloneable {

    private int age;

    private String name;

    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ConcretePrototype prototype = null;
        try {
            prototype = (ConcretePrototype) super.clone();
            prototype.list = (ArrayList) list.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prototype;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(18);
        cp.setName("Tom");
        cp.list.add("Tom");

        try {
            //clone能把原来的属性也拷贝过来,能够拷贝的数据类型只有八大基础数据类型+String
            //其他属性类型如ArrayList<String>，需要在clone方法里再进行拷贝，否则就是拷贝引用
            ConcretePrototype copy = (ConcretePrototype) cp.clone();
            System.out.println(copy.list == cp.list);
            System.out.println(copy.getAge() + "," + copy.getName() + "," + copy.list.size());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
