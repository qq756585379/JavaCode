package com.java.fix.factory.simple;

import com.java.fix.factory.Audi;
import com.java.fix.factory.Benz;
import com.java.fix.factory.Bmw;
import com.java.fix.factory.Car;

public class SimpleFactory {

    public static void main(String[] args) {
        Car car = new SimpleFactory().getCar("Audi");
        System.out.println(car.getName());
    }

    private Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)) {
            return new Bmw();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return new Benz();
        } else if ("Audi".equalsIgnoreCase(name)) {
            return new Audi();
        } else {
            return null;
        }
    }
}
