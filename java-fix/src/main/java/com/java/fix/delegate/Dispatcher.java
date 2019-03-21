package com.java.fix.delegate;

/**
 * 额外增加功能可以用代理模式，委派模式不做功能增加
 */
public class Dispatcher implements IExector {

    private IExector exector;

    private Dispatcher(IExector exector) {
        this.exector = exector;
    }

    public void doing() {
        this.exector.doing();
    }

    /**
     * 项目经理和员工A都属于公司员工，项目经理委托员工A干活
     */
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(new ExectorA());
        dispatcher.doing();
    }
}
