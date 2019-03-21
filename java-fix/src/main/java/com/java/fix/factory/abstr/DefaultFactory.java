package com.java.fix.factory.abstr;

import com.java.fix.factory.Car;

public class DefaultFactory extends AbstractFactory {

    private AudiFactory defaultFactory = new AudiFactory();

    public Car getCar() {
        return defaultFactory.getCar();
    }

}
