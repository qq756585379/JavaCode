package com.yang.util;

import com.yang.model.Student;

import java.lang.reflect.Method;

public class PropertyUtil {

    /**
     * 获取对象的属性值
     */
    public static <T> Object getProperty(T obj, String propertyName) throws Exception {
        Class<?> clazz = obj.getClass();
        String methodName = "get" + capitalize(propertyName);
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
    private static String capitalize(final String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }

        final char firstChar = str.charAt(0);
        final char newChar = Character.toTitleCase(firstChar);
        if (firstChar == newChar) {
            return str; // already capitalized
        }

        char[] newChars = new char[strLen];
        newChars[0] = newChar;
        str.getChars(1, strLen, newChars, 1);
        return String.valueOf(newChars);
    }


    public static void main(String[] args) {
        String string = capitalize("aaa");
        System.out.println(string);

        Student student = new Student();
        student.setScore(98);
        student.setSno("1010110");
        student.setAge(18);
        student.setId(1001L);
        student.setSex(1);
        student.setName("yj");

        try {
            Long id = (Long) getProperty(student, "id");
            String name = (String) getProperty(student, "name");
            System.out.println("id = " + id);
            System.out.println("name = " + name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
