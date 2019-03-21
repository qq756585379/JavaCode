package com.java.fix.factory.abstr;

import com.java.fix.factory.Bmw;
import com.java.fix.factory.Car;

public class BmwFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Bmw();
	}

}
