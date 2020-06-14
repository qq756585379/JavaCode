package com.java.fix.template;

/**
 * 模板模式，流程标准化
 * 原型模式，一根猴毛，变出千万个
 * 策略模式，执行过程不一样，但结果一样
 * 委托模式，项目经理让你去干活
 */
public class TestTemplate {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.create();

        Tea tea = new Tea();
        tea.create();


        Integer a =null;
        Integer b = a/100;

    }

    //SpringJDBC
    //是java规范，各个数据库厂商自己去实现
    //1.加载驱动类DriverManager
    //2.建立连接
    //3.创建语句集（标准语句集，预处理语句集）
    //4.执行语句集
    //5.结果集
}
