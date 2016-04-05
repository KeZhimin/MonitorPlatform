package com.ffcs.sys.entity;

import java.util.List;

public class SysGroupStructureAcl {
	@Override
	public String toString() {
		return "SysGroupStructureAcl [aclId=" + aclId + ", groupId=" + groupId + ", structureId=" + structureId
				+ ", privs=" + privs + "]";
	}

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