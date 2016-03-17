package com.ffcs.mp.pri.dao;

import com.ffcs.mp.pri.entity.SysSecurityLog;
import java.math.BigDecimal;

public interface SysSecurityLogMapper {
    int deleteByPrimaryKey(BigDecimal logid);

    int insert(SysSecurityLog record);

    int insertSelective(SysSecurityLog record);

    SysSecurityLog selectByPrimaryKey(BigDecimal logid);

    int updateByPrimaryKeySelective(SysSecurityLog record);

    int updateByPrimaryKey(SysSecurityLog record);
}