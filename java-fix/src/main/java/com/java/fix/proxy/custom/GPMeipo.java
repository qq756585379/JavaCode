package com.java.fix.proxy.custom;

import com.java.fix.proxy.jdk.Person;

import java.lang.reflect.Method;

public class GPMeipo implements GPInvocationHandler {

    private Person target;

    public Object getInstance(Person target) throws Exception {
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("被代理对象的class是:" + clazz);
        return GPPorxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("媒婆：我是媒婆，我替你找对象");
        System.out.println("------------");

        method.invoke(this.target, args);

        System.out.println("------------");
        System.out.println("媒婆：好的，我这就去找");

        return null;
    }
}
