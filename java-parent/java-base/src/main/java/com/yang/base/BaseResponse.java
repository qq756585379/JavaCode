package com.yang.base;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    /**
     * 成功
     */
    public static final int RESULT_CODE_SUCCESS = 0;

    /**
     * 数据校验失败
     */
    public static final int RESULT_CODE_VALIDATE_FAILED = -1;

    /**
     * 服务不可用
     */
    public static final int RESULT_CODE_SERVICE_UNAVAILABLE = -98;

    /**
     * 未知错误
     */
    public static final int RESULT_CODE_UNKNOWN = -99;

    /**
     * 响应码，默认为0
     */
    private int resultCode = RESULT_CODE_SUCCESS;

    /**
     * 响应码对应的描述信息，特有情况下可以设定
     */
    private String resultMessage;

    /**
     * 响应码对应的描述信息，特有情况下可以设定，面向调用方的开发人员，比较详细的调用代码描述，方面前端开发人员定位问题
     */
    private String debugResultMessage;

    public void setResultCodeAndMessage(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getDebugResultMessage() {
        return debugResultMessage;
    }

    public void setDebugResultMessage(String debugResultMessage) {
        this.debugResultMessage = debugResultMessage;
    }
}
