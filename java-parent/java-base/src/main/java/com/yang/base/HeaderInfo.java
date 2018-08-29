package com.yang.base;

import com.yang.utils.Identities;

import java.io.Serializable;

/**
 * {"applicationCode":"OP","clientId":"30cdf5a24e2449b993ffda82f3b73bc5",
 * "sourceId":"M0000011","exSourceId":"CJIA","channel":"CJIA","subChannel":"OP",
 * "version":"2.0.0","userToken":"de518834-a468-4e0d-911d-1e354a6db5a2"}
 */
public class HeaderInfo implements Serializable {

    private String id = Identities.uuid2();
    private String userId;
    private String loginName;
    private String userToken;
    private String applicationCode;
    private String clientId;
    private String sourceId;
    private String version;
    private String serviceVersion;
    private String channel;
    private String subChannel;
    private String serviceCode;
    private String contentType;
    private String requestId;
    private String exSourceId;

    public HeaderInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSubChannel() {
        return subChannel;
    }

    public void setSubChannel(String subChannel) {
        this.subChannel = subChannel;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getExSourceId() {
        return exSourceId;
    }

    public void setExSourceId(String exSourceId) {
        this.exSourceId = exSourceId;
    }
}
