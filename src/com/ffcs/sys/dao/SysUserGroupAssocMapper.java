package com.ffcs.sys.dao;

import java.util.List;

import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.entity.SysUserGroupAssoc;

public interface SysUserGroupAssocMapper extends CommMapper<SysUserGroupAssoc>{
	 List<SysUserGroupAssoc> getGroupByUserId(SysUser id);
}