package com.ffcs.sys.dao;

import com.ffcs.sys.entity.SysGroupServAcl;

public interface SysGroupServAclMapper {
    int deleteByPrimaryKey(Integer servAclId);

    int insert(SysGroupServAcl record);

    int insertSelective(SysGroupServAcl record);

    SysGroupServAcl selectByPrimaryKey(Integer servAclId);

    int updateByPrimaryKeySelective(SysGroupServAcl record);

    int updateByPrimaryKey(SysGroupServAcl record);
}