package com.ffcs.sys.service;

import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.entity.SysUserGroupAssoc;

public interface SysUserGroupAssocService extends CommService<SysUserGroupAssoc> {
	  //List<SysUserGroupAssoc> getGroupByUserId(SysUser sysUser);

	 int insertSelective(SysUser sysUser, Integer[] groupid);

	int updateByPrimaryKeySelective(SysUser sysUser, Integer[] groupid);


}
