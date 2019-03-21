package com.java.fix.factory.func;

import com.java.fix.factory.Benz;
import com.java.fix.factory.Car;

public class BenzFactory implements Factory {

	@Override
	public Car getCar() {
		return new Benz();
	}

}
