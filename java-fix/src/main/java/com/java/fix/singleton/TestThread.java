package com.java.fix.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class TestThread {

    public static void main(String[] args) {
        int count = 100;

        CountDownLatch latch = new CountDownLatch(count);

        final Set<Singleton1> syncSet = Collections.synchronizedSet(new HashSet<Singleton1>());
        final Set<Singleton2> syncSet2 = Collections.synchronizedSet(new HashSet<Singleton2>());

        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    syncSet.add(Singleton1.getInstance());
                    syncSet2.add(Singleton2.getInstance());
                }
            }.start();
            latch.countDown();
        }

        try {
            latch.await();
            System.out.println(syncSet.size());
            System.out.println(syncSet2.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
