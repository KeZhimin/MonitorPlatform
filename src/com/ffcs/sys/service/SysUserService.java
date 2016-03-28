package com.ffcs.sys.service;

import java.util.Map;

import com.ffcs.sys.entity.SysUser;
import com.github.pagehelper.PageInfo;


public interface SysUserService {
	
	int deleteByPks(Integer[] deleteId);
	
	int updateIsEnable(Integer[] isId);
	
	int insertSelective(SysUser entity);
	
	int updateUserIsEnable(Integer[] id );
	
	int deleteByPrimaryKey(Integer userId);
	
	int updateByPrimaryKeySelective(SysUser entity);
	
	SysUser getSysUserByName(String userName);
	
	SysUser selectByUserId(Integer primaryKey);
	
    PageInfo<SysUser> getUserList(PageInfo<SysUser> pageInfo,Map<String,Object> params);
    

   

    

	
}
