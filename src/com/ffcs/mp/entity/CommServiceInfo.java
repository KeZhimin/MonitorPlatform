package com.ffcs.mp.entity;

import java.util.Date;

public class CommServiceInfo {
    private Integer servId;

    private Integer orgId;

    private String servTitle;

    private String servUnifyUrl;

    private Short isEnable;

    private Short isEncry;

    private Short povCode;

    private Short cityCode;

    private Date ctime;

    private Date utime;

    private Integer updateAutor;

    public Integer getServId() {
        return servId;
    }

    public void setServId(Integer servId) {
        this.servId = servId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getServTitle() {
        return servTitle;
    }

    public void setServTitle(String servTitle) {
        this.servTitle = servTitle;
    }

    public String getServUnifyUrl() {
        return servUnifyUrl;
    }

    public void setServUnifyUrl(String servUnifyUrl) {
        this.servUnifyUrl = servUnifyUrl;
    }

    public Short getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Short isEnable) {
        this.isEnable = isEnable;
    }

    public Short getIsEncry() {
        return isEncry;
    }

    public void setIsEncry(Short isEncry) {
        this.isEncry = isEncry;
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