package com.java.fix.factory.abstr;

import com.java.fix.factory.Audi;
import com.java.fix.factory.Car;

public class AudiFactory extends AbstractFactory {

    @Override
    protected Car getCar() {
        return new Audi();
    }
}
