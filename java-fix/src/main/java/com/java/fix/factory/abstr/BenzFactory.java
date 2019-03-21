package com.java.fix.factory.abstr;

import com.java.fix.factory.Benz;
import com.java.fix.factory.Car;

public class BenzFactory extends AbstractFactory {

    @Override
    public Car getCar() {
        return new Benz();
    }

}
