package com.ffcs.sys.dao;

import java.util.List;

import com.ffcs.sys.entity.SysGroup;

public interface SysGroupMapper {
	    //
	   int insert(SysGroup entity);
	   //
	   int insertSelective(SysGroup entity);
	   //
	   int updateByPrimaryKeySelective(SysGroup entity);
	   //
	   int updateByPrimaryKey(SysGroup entity);
	   //
	   int deleteByPrimaryKey(Integer primaryKey);

	   //
	   List<SysGroup> selectByUserId(Integer userId);
	   //
	   List<SysGroup> selectList();
	   //
	   SysGroup selectByPrimaryKey(Integer primaryKey);
	
    
}