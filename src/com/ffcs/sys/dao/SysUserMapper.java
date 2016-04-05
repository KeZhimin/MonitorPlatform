package com.ffcs.sys.dao;

import java.util.List;

import com.ffcs.sys.entity.SysUser;

public interface SysUserMapper {
	
	int deleteByPrimaryKey(Integer primaryKey);

   

    int insertSelective(SysUser user);

    int updateByUserIdSelective(SysUser user);

    int updateUserIsEnable(Integer isEnable);

    int  deleteByPks(Integer integer);

    int updateIsEnable(Integer integer);
    
    SysUser selectByUserId(Integer userId);
    
    SysUser getSysUserByName(String userName);
    
    List<SysUser> selectList(SysUser user);
    
    List<SysUser> getUser();

    
    List<SysUser> getUserByGroupId(Integer id);
	
	
 
   
} 