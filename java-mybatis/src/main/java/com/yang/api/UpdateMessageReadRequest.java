package com.yang.api;

import com.yang.base.PageRequest;

public class UpdateMessageReadRequest extends PageRequest {

    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

}
