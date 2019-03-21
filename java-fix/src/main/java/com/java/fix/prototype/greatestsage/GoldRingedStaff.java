package com.java.fix.prototype.greatestsage;

import java.io.Serializable;

public class GoldRingedStaff implements Serializable {

    private float height = 100;

    private float diameter = 10;

    public void grow() {
        this.diameter *= 2;
        this.height *= 2;
    }

    public void shrink() {
        this.diameter /= 2;
        this.height /= 2;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }
}
