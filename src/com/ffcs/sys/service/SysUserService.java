package com.ffcs.sys.service;

import com.ffcs.sys.entity.SysUser;


public interface SysUserService extends CommService<SysUser> {
	 public SysUser getSysUserByName(String userName);

	public int updateUserIsEnable(Integer[] id );

	public int deleteByPks(Integer[] deleteId);

	public int updateIsEnable(Integer[] isId);

	
}
