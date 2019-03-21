package com.java.fix.singleton;

/**
 * 以上懒汉式单例的实现没有考虑线程安全问题，它是线程不安全的，并发环境下很可能出现多个Singleton1 实例
 */
public class Singleton1 {

    private Singleton1() {
    }

    private static Singleton1 single = null;

    public static Singleton1 getInstance() {
        if (single == null) {
            single = new Singleton1();
        }
        return single;
    }
}
