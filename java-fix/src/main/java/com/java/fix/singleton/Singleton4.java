package com.java.fix.singleton;

/**
 * 懒汉式（静态内部类）
 */
public class Singleton4 {

    private static int a = 1;

    static {
        Singleton4.a = 2;
    }

    private static class LazyHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }

    public static final Singleton4 getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(Singleton4.a);
    }
}
