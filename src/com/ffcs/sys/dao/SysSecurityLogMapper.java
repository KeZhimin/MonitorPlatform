package com.ffcs.sys.dao;

import java.math.BigDecimal;

import com.ffcs.sys.entity.SysSecurityLog;

public interface SysSecurityLogMapper {
    int deleteByPrimaryKey(BigDecimal logid);

    int insert(SysSecurityLog record);

    int insertSelective(SysSecurityLog record);

    SysSecurityLog selectByPrimaryKey(BigDecimal logid);

    int updateByPrimaryKeySelective(SysSecurityLog record);

    int updateByPrimaryKey(SysSecurityLog record);
}