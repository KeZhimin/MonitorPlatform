package com.ffcs.mp.entity;

import java.util.Date;

public class CommSeverInfo {
    private Long servId;

    private Integer orgId;

    private Short isEnable;

    private String servTitle;

    private String outerIp;

    private String innerIp;

    private Integer monitDelay;

    private Short povCode;

    private Short cityCode;

    private Date ctime;

    private Date utime;

    private Integer updateAutor;

    public Long getServId() {
        return servId;
    }

    public void setServId(Long servId) {
        this.servId = servId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Short getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Short isEnable) {
        this.isEnable = isEnable;
    }

    public String getServTitle() {
        return servTitle;
    }

    public void setServTitle(String servTitle) {
        this.servTitle = servTitle;
    }

    public String getOuterIp() {
        return outerIp;
    }

    public void setOuterIp(String outerIp) {
        this.outerIp = outerIp;
    }

    public String getInnerIp() {
        return innerIp;
    }

    public void setInnerIp(String innerIp) {
        this.innerIp = innerIp;
    }

    public Integer getMonitDelay() {
        return monitDelay;
    }

    public void setMonitDelay(Integer monitDelay) {
        this.monitDelay = monitDelay;
    }

    public Short getPovCode() {
        return povCode;
    }

    public void setPovCode(Short povCode) {
        this.povCode = povCode;
    }

    public Short getCityCode() {
        return cityCode;
    }

    public void setCityCode(Short cityCode) {
        this.cityCode = cityCode;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Integer getUpdateAutor() {
        return updateAutor;
    }

    public void setUpdateAutor(Integer updateAutor) {
        this.updateAutor = updateAutor;
    }
}