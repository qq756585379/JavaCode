package com.java.fix.prototype.greatestsage;

import java.io.*;
import java.util.Date;

public class TheGreatestSage extends Monkey implements Cloneable, Serializable {

    //金箍棒
    private GoldRingedStaff staff;

    public TheGreatestSage() {
        this.staff = new GoldRingedStaff();
        this.birthday = new Date();
        this.height = 150;
        this.weight = 30;
    }

    //分身技能
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //return super.clone();
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            TheGreatestSage copy = (TheGreatestSage) ois.readObject();
            copy.birthday = new Date();
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //变化
    public void change() {
        TheGreatestSage copySage = null;
        try {
            copySage = (TheGreatestSage) clone();
            System.out.println("大圣生日：" + this.getBirthday().getTime());
            System.out.println("分身生日：" + copySage.getBirthday().getTime());
            System.out.println("大圣和分身是否是同一个对象：" + (this == copySage));
            System.out.println("大圣的金箍棒和分身的金箍棒是否为同一个对象：" + (this.getStaff() == copySage.getStaff()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public GoldRingedStaff getStaff() {
        return staff;
    }

    public void setStaff(GoldRingedStaff staff) {
        this.staff = staff;
    }

    public static void main(String[] args) {
        TheGreatestSage sage = new TheGreatestSage();
        sage.change();
    }
}
