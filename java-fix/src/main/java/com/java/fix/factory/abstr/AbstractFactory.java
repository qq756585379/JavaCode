package com.java.fix.factory.abstr;

import com.java.fix.factory.Car;
import com.java.fix.factory.func.AudiFactory;
import com.java.fix.factory.func.BenzFactory;
import com.java.fix.factory.func.BmwFactory;

public abstract class AbstractFactory {

    protected abstract Car getCar();

    public Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)) {
            return new BmwFactory().getCar();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return new BenzFactory().getCar();
        } else if ("Audi".equalsIgnoreCase(name)) {
            return new AudiFactory().getCar();
        } else {
            return null;
        }
    }
}
