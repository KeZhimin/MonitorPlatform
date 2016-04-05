package com.ffcs.sys.dao;

import java.util.List;

import com.ffcs.sys.entity.SysUserGroupAssoc;

public interface SysUserGroupAssocMapper{
	// List<SysUserGroupAssoc> getGroupByUserId(SysUser id);
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysUserGroupAssoc entity);

    int insertSelective(SysUserGroupAssoc entity);

    SysUserGroupAssoc selectByPrimaryKey(Integer primaryKey);
    
    List<SysUserGroupAssoc> selectList();

    int updateByPrimaryKeySelective(SysUserGroupAssoc entity);

    int updateByPrimaryKey(SysUserGroupAssoc entity);
    
    int add(List<SysUserGroupAssoc> list);
    
    void deleteByGroupId(Integer groupId);
	
}