package com.mall.portal.pojo;

import java.util.Date;

public class SubwaysAdgroupCreative {
    private Long id;

    private Long creativeId;

    private Long adgroupId;

    private String title;

    private String imgUrl;

    private String auditStatus;

    private String auditDesc;

    private Date createTime;

    private Date modifiedTime;

    private Boolean imgType;

    private String secondImgOriginUrl;

    private String status;

    private Date startTime;

    private Date endTime;

    private String platformType;

    private String nick;

    private Integer retry;

    public SubwaysAdgroupCreative(Long id, Long creativeId, Long adgroupId, String title, String imgUrl, String auditStatus, String auditDesc, Date createTime, Date modifiedTime, Boolean imgType, String secondImgOriginUrl, String status, Date startTime, Date endTime, String platformType, String nick, Integer retry) {
        this.id = id;
        this.creativeId = creativeId;
        this.adgroupId = adgroupId;
        this.title = title;
        this.imgUrl = imgUrl;
        this.auditStatus = auditStatus;
        this.auditDesc = auditDesc;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.imgType = imgType;
        this.secondImgOriginUrl = secondImgOriginUrl;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.platformType = platformType;
        this.nick = nick;
        this.retry = retry;
    }

    public SubwaysAdgroupCreative() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreativeId() {
        return creativeId;
    }

    public void setCreativeId(Long creativeId) {
        this.creativeId = creativeId;
    }

    public Long getAdgroupId() {
        return adgroupId;
    }

    public void setAdgroupId(Long adgroupId) {
        this.adgroupId = adgroupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc == null ? null : auditDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean getImgType() {
        return imgType;
    }

    public void setImgType(Boolean imgType) {
        this.imgType = imgType;
    }

    public String getSecondImgOriginUrl() {
        return secondImgOriginUrl;
    }

    public void setSecondImgOriginUrl(String secondImgOriginUrl) {
        this.secondImgOriginUrl = secondImgOriginUrl == null ? null : secondImgOriginUrl.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType == null ? null : platformType.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public Integer getRetry() {
        return retry;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
    }
}