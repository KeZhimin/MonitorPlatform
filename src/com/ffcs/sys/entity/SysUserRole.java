package com.ffcs.sys.entity;

import java.util.List;


public class SysUserRole {
	  private SysUser sysUser;
	  private List<SysGroup> sysGroup;

	public List<SysGroup> getSysGroup() {
		return sysGroup;
	}
	public void setSysGroup(List<SysGroup> sysGroup) {
		this.sysGroup = sysGroup;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	   
	
}
