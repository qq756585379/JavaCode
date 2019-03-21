package com.java.fix.proxy.cglib;

public class TestGglibProxy {

    public static void main(String[] args) {
        try {
            YunZhongYu obj = (YunZhongYu) new GPMeipo().getInstance(YunZhongYu.class);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
