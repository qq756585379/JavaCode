package com.java.fix.proxy.custom;

import java.lang.reflect.Method;

public interface GPInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
