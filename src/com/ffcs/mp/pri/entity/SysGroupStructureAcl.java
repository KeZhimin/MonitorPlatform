package com.ffcs.mp.pri.entity;

public class SysGroupStructureAcl {
    private Integer aclId;

    private Integer groupId;

    private Integer structureId;

    private Short privs;

    public Integer getAclId() {
        return aclId;
    }

    public void setAclId(Integer aclId) {
        this.aclId = aclId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getStructureId() {
        return structureId;
    }

    public void setStructureId(Integer structureId) {
        this.structureId = structureId;
    }

    public Short getPrivs() {
        return privs;
    }

    public void setPrivs(Short privs) {
        this.privs = privs;
    }
}