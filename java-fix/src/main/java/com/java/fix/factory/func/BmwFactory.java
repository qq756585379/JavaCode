package com.java.fix.factory.func;

import com.java.fix.factory.Bmw;
import com.java.fix.factory.Car;

public class BmwFactory implements Factory {

	@Override
	public Car getCar() {
		return new Bmw();
	}

}
