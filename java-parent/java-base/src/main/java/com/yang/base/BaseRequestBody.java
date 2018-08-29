package com.yang.base;

import java.io.Serializable;

public class BaseRequestBody implements Serializable {

    /**
     * 请求服务对应的权限代码
     */
    private String functionNo;

    /**
     * 定义服务请求的版本
     */
    private Integer serviceVersion;

    public String getFunctionNo() {
        return functionNo;
    }

    public void setFunctionNo(String functionNo) {
        this.functionNo = functionNo;
    }

    public Integer getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(Integer serviceVersion) {
        this.serviceVersion = serviceVersion;
    }
}

