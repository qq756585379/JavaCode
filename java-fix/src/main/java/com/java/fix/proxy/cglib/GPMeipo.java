package com.java.fix.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class GPMeipo implements MethodInterceptor {

    public Object getInstance(Class clazz) throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //1.生成源代码
        //2.编译成class文件
        //3.加载到JVM中，并返回代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("我马上帮你找对象");
        System.out.println("------------");
        proxy.invokeSuper(obj, args);//调用obj的方法就会被intercept拦截，会死循环，所以要调父类方法
        System.out.println("------------");
        return null;
    }
}
