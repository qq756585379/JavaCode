package com.yang.base;

import java.io.Serializable;

public enum SortDirection implements Serializable {

    /**
     * 目前支持排序规则有ASC，DESC
     */
    ASC("ASC"), DESC("DESC");

    /**
     * 排序规则
     */
    private String code;

    SortDirection(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "[" + this.name() + " = " + this.getCode() + "]";
    }
}
