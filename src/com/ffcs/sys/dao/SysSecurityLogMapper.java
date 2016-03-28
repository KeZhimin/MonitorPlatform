package com.ffcs.sys.dao;

import java.util.List;
import java.util.Map;

import com.ffcs.sys.entity.SysSecurityLog;


public interface SysSecurityLogMapper {

	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysSecurityLog entity);

    int insertSelective(SysSecurityLog entity);

    SysSecurityLog selectByPrimaryKey(Integer primaryKey);
    
    List<SysSecurityLog> selectList();

    int updateByPrimaryKeySelective(SysSecurityLog entity);

    int updateByPrimaryKey(SysSecurityLog entity);

	List<SysSecurityLog>  selectByDate(Map<String, Object> params);
   
}