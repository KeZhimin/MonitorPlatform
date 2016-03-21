package com.ffcs.sys.dao;

import java.util.List;

import com.ffcs.sys.entity.SysGroupStructureAcl;
import com.ffcs.sys.entity.SysUserGroupAssoc;

public interface SysGroupStructureAclMapper extends CommMapper<SysGroupStructureAcl>{
	
	List<SysGroupStructureAcl> selectByGroupId(SysUserGroupAssoc sysUserGroupAssoc);
}