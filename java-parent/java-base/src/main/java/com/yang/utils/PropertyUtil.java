package com.yang.utils;

import java.lang.reflect.Method;

public class PropertyUtil {

    /**
     * 获取对象的属性值
     */
    public static <T> Object getProperty(T obj, String propertyName) throws Exception {
        Class<?> clazz = obj.getClass();
        String methodName = "get" + capitalFirstChar(propertyName);
        System.out.println("methodName = " + methodName);

        Method method = getMethod(clazz, methodName);
        if (null == method) {
            throw new Exception(clazz.getName() + " don't have menthod --> " + methodName);
        }

        return method.invoke(obj);
    }

    /**
     * 本类不存在该方法，递归遍历查看父类是否存在
     */
    public static Method getMethod(Class<?> clazz, String methodName) {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName);
        } catch (NoSuchMethodException e) {
            clazz = clazz.getSuperclass();
            if (null != clazz) {
                method = getMethod(clazz, methodName);
            }
        }
        return method;
    }

    /**
     * 首字母转大写
     */
    public static String capitalFirstChar(String name) {
        if (null != name && name.length() > 0) {
            char firstChar = name.charAt(0);
            return Character.toUpperCase(firstChar) + name.substring(1);
        }
        return name;
    }

    /**
     * 将首字母转换为小写
     */
    public static String unCapitalFirstChar(String name) {
        if (null != name && name.length() > 0) {
            char first = name.charAt(0);
            return Character.toLowerCase(first) + name.substring(1);
        }
        return name;
    }



    public static void main(String[] args) {
        String string = capitalFirstChar("aaa");
        String string2 = unCapitalFirstChar("Aaa");
        System.out.println(string);
        System.out.println(string2);

        // Student student = new Student();
        // student.setScore(98);
        // student.setSno("1010110");
        // student.setAge(18);
        // student.setId(1001L);
        // student.setSex(1);
        // student.setName("yj");
        //
        // try {
        //     Long id = (Long) getProperty(student, "id");
        //     String name = (String) getProperty(student, "name");
        //     System.out.println("id = " + id);
        //     System.out.println("name = " + name);
        //
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
}
