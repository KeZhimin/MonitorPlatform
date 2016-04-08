package com.ffcs.sys.entity;

public class SysGroupOrgAcl {
    private Integer orgAclId;

    private Integer groupId;

    private Integer orgId;

    public Integer getOrgAclId() {
        return orgAclId;
    }

    public void setOrgAclId(Integer orgAclId) {
        this.orgAclId = orgAclId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}