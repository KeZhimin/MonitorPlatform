package com.ffcs.mp.entity;

public class CommOrgInfo {
    private Integer orgId;

    private String orgName;

    private Integer porgId;

    private Short isLeaf;

    private String orgDesc;

    private Short orgType;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getPorgId() {
        return porgId;
    }

    public void setPorgId(Integer porgId) {
        this.porgId = porgId;
    }

    public Short getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Short isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    public Short getOrgType() {
        return orgType;
    }

    public void setOrgType(Short orgType) {
        this.orgType = orgType;
    }
}