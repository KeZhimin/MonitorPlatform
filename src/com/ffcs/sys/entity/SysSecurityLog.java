package com.ffcs.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SysSecurityLog {
    private Integer logid;

    private String loginName;

    private String ipaddress;

    private String operation;

    private Date ctime;


    public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

	@Override
	public String toString() {
		return "SysSecurityLog [logid=" + logid + ", loginName=" + loginName
				+ ", ipaddress=" + ipaddress + ", operation=" + operation
				+ ", ctime=" + ctime + "]";
	}

	
    
}