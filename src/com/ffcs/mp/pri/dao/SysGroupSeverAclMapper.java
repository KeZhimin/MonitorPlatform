package com.ffcs.mp.pri.dao;

import com.ffcs.mp.pri.entity.SysGroupSeverAcl;

public interface SysGroupSeverAclMapper {
    int deleteByPrimaryKey(Integer servAclId);

    int insert(SysGroupSeverAcl record);

    int insertSelective(SysGroupSeverAcl record);

    SysGroupSeverAcl selectByPrimaryKey(Integer servAclId);

    int updateByPrimaryKeySelective(SysGroupSeverAcl record);

    int updateByPrimaryKey(SysGroupSeverAcl record);
}