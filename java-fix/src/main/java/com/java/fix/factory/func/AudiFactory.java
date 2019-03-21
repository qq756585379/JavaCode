package com.java.fix.factory.func;

import com.java.fix.factory.Audi;
import com.java.fix.factory.Car;

public class AudiFactory implements Factory {

    @Override
    public Car getCar() {
        return new Audi();
    }

}
