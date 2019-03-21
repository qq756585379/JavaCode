package com.java.fix.singleton;

import java.io.Serializable;

/**
 * 饿汉式单例类
 */
public class Singleton implements Serializable {

    public static Singleton INSTANCE = new Singleton();

    protected Singleton() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
