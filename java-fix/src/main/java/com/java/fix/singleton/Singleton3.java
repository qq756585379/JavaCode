package com.java.fix.singleton;

/**
 * 懒汉式单例.双重锁检查
 */
public class Singleton3 {

    private Singleton3() {
    }

    private static Singleton3 single = null;

    public static Singleton3 getInstance() {
        if (single == null) {
            synchronized (Singleton3.class) {
                if (single == null) {
                    single = new Singleton3();
                }
            }
        }
        return single;
    }
}
