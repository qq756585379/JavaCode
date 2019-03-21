package com.java.fix.singleton;

public class TestSingleton {

    private String name = null;

    private TestSingleton() {
    }

    private static volatile TestSingleton instance = null;

    public static TestSingleton getInstance() {
        if (instance == null) {
            synchronized (TestSingleton.class) {
                if (instance == null) {
                    instance = new TestSingleton();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("the name is " + name);
    }

    public static void main(String[] args) {
        TestSingleton ts1 = TestSingleton.getInstance();
        ts1.setName("james");
        TestSingleton ts2 = TestSingleton.getInstance();
        ts2.setName("tom");

        ts1.printInfo();
        ts2.printInfo();

        if (ts1 == ts2) {
            System.out.println(ts1.getName());
        } else {
            System.out.println(ts2.getName());
        }
    }
}
