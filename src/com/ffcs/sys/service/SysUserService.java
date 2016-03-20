package com.ffcs.sys.service;

import com.ffcs.sys.entity.SysUser;


public interface SysUserService extends CommService<SysUser> {
	 public SysUser getSysUserByName(String userName);
}
