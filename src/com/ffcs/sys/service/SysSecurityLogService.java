package com.ffcs.sys.service;

import java.util.List;
import java.util.Map;

import com.ffcs.sys.entity.SysSecurityLog;
import com.github.pagehelper.PageInfo;

public interface SysSecurityLogService {
	 List<SysSecurityLog> selectByDate( Map<String, Object> params);
	 
	 int deleteByPrimaryKey(Integer primaryKey);

	    int insert(SysSecurityLog entity);

	    int insertSelective(SysSecurityLog entity);
	    PageInfo<SysSecurityLog> selectList(PageInfo<SysSecurityLog> pageInfo,Map<String,Object> params);
	    SysSecurityLog selectByPrimaryKey(Integer primaryKey);

	    int updateByPrimaryKeySelective(SysSecurityLog entity);

	    int updateByPrimaryKey(SysSecurityLog entity);
}
