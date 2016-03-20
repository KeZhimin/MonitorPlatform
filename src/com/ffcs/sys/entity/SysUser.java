package com.ffcs.sys.entity;

import java.util.Date;

public class SysUser {
    private Integer userId;

    private String longinName;

    private String password;

    private String fullName;

    private Date ctime;

    private Short isEnabled;

    private Short isDeleted;

    private Short povCode;

    private Long phoneNum;

    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLonginName() {
        return longinName;
    }

    public void setLonginName(String longinName) {
        this.longinName = longinName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
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

    public Short getPovCode() {
        return povCode;
    }

    public void setPovCode(Short povCode) {
        this.povCode = povCode;
    }

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", longinName=" + longinName
				+ ", password=" + password + ", fullName=" + fullName
				+ ", ctime=" + ctime + ", isEnabled=" + isEnabled
				+ ", isDeleted=" + isDeleted + ", povCode=" + povCode
				+ ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}
    
}