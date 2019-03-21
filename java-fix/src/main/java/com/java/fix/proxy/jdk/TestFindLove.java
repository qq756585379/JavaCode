package com.java.fix.proxy.jdk;

import com.java.fix.proxy.custom.GPMeipo;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class TestFindLove {

    public static void main(String[] args) {
        // test1();
        // test2();
        test3();
    }

    private static void test1() {
        try {
            XiaoXingxing xingxing = new XiaoXingxing();
            Person obj = (Person) new Meipo().getInstance(xingxing);
            System.out.println("代理对象的class：" + obj.getClass());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        try {
            byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("/Users/yangjun/Desktop/logs/$Proxy0.class");
            os.write(data);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test3() {
        try {
            Person obj = (Person) new GPMeipo().getInstance(new XiaoXingxing());
            System.out.println("代理对象的class：" + obj.getClass());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
