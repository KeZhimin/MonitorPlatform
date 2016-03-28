package com.ffcs.sys.dao;

import java.util.List;

import com.ffcs.sys.entity.SysGroupStructureAcl;
import com.ffcs.sys.entity.SysUserGroupAssoc;

public interface SysGroupStructureAclMapper {
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysGroupStructureAcl entity);

    int insertSelective(SysGroupStructureAcl entity);

    SysGroupStructureAcl selectByPrimaryKey(Integer primaryKey);
    
    List<SysGroupStructureAcl> selectList();

    int updateByPrimaryKeySelective(SysGroupStructureAcl entity);

    int updateByPrimaryKey(SysGroupStructureAcl entity);
	List<SysGroupStructureAcl> selectByGroupId(SysUserGroupAssoc sysUserGroupAssoc);
}