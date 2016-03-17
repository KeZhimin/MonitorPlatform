package com.ffcs.mp.pri.entity;

public class SysGroup {
	private Integer groupId;

	private String groupName;

	private Short isEnabled;

	private Short isDeleted;

	private Short grade;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Short getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Short isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Short getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Short getGrade() {
		return grade;
	}

	public void setGrade(Short grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "SysGroup [groupId=" + groupId + ", groupName=" + groupName + ", isEnabled=" + isEnabled + ", isDeleted="
				+ isDeleted + ", grade=" + grade + "]";
	}

}