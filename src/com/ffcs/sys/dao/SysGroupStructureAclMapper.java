package com.ffcs.sys.dao;

import com.ffcs.sys.entity.SysGroupStructureAcl;

public interface SysGroupStructureAclMapper {
    int deleteByPrimaryKey(Integer aclId);

    int insert(SysGroupStructureAcl record);

    int insertSelective(SysGroupStructureAcl record);

    SysGroupStructureAcl selectByPrimaryKey(Integer aclId);

    int updateByPrimaryKeySelective(SysGroupStructureAcl record);

    int updateByPrimaryKey(SysGroupStructureAcl record);
}