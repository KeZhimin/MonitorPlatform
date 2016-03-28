package com.ffcs.sys.service;

import java.util.Map;

import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.entity.SysUserGroupAssoc;
import com.github.pagehelper.PageInfo;

public interface SysUserGroupAssocService {
	  //List<SysUserGroupAssoc> getGroupByUserId(SysUser sysUser);

	 int insertSelective(SysUser sysUser, Integer[] groupid);

	int updateByPrimaryKeySelective(SysUser sysUser, Integer[] groupid);

	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysUserGroupAssoc entity);

    int insertSelective(SysUserGroupAssoc entity);
    PageInfo<SysUserGroupAssoc> selectList(PageInfo<SysUserGroupAssoc> pageInfo,Map<String,Object> params);
    SysUserGroupAssoc selectByPrimaryKey(Integer primaryKey);

    int updateByPrimaryKeySelective(SysUserGroupAssoc entity);

    int updateByPrimaryKey(SysUserGroupAssoc entity);

}
