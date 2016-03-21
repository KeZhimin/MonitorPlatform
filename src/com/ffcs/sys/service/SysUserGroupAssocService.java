package com.ffcs.sys.service;

import java.util.List;

import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.entity.SysUserGroupAssoc;

public interface SysUserGroupAssocService extends CommService<SysUserGroupAssoc> {
	  List<SysUserGroupAssoc> getGroupByUserId(SysUser sysUser);
}
