package com.java.fix.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 登记式单例
 * 从上往下，先属性后方法，先静态后动态
 * Java类加载器加载内容的顺序：
 * 1、从上往下（Java的变量需要先声明才能使用）
 * 2、静态后动态(对象实例化)（静态块和static关键字修饰在实例化之前分配内存空间）
 * 3、先属性后方法（成员变量不能定义在方法中，只能定义在class下）
 */
public class Singleton5 {

    private static Map<String, Singleton5> map = new HashMap<>();

    static {
        Singleton5 single = new Singleton5();
        map.put(single.getClass().getName(), single);
    }

    private Singleton5() {
    }

    /**
     * 登记式单例实际上维护了一组单例类的实例，将这些实例存放在一个Map（登记薄）中，
     * 对于已经登记过的实例，则从Map直接返回，对于没有登记的，则先登记，然后返回。
     * 这里我对登记式单例标记了可忽略，我的理解来说，
     * 首先它用的比较少，另外其实内部实现还是用的饿汉式单例，
     * 因为其中的static方法块，它的单例在类被装载的时候就被实例化了。
     */
    public static Singleton5 getInstance(String name) {
        if (name == null) {
            name = Singleton5.class.getName();
        }
        if (map.get(name) == null) {
            try {
                map.put(name, (Singleton5) Class.forName(name).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }

    public static void main(String[] args) {
        System.out.println(Singleton5.getInstance(null));
    }
}
