package com.ffcs.sys.dao;

import com.ffcs.sys.entity.SysGroupOrgAcl;

public interface SysGroupOrgAclMapper {
    int deleteByPrimaryKey(Integer orgAclId);

    int insert(SysGroupOrgAcl record);

    int insertSelective(SysGroupOrgAcl record);

    SysGroupOrgAcl selectByPrimaryKey(Integer orgAclId);

    int updateByPrimaryKeySelective(SysGroupOrgAcl record);

    int updateByPrimaryKey(SysGroupOrgAcl record);
}