package com.ffcs.mp.pri.dao;

import com.ffcs.mp.pri.entity.SysGroupStructureAcl;

public interface SysGroupStructureAclMapper {
    int deleteByPrimaryKey(Integer aclId);

    int insert(SysGroupStructureAcl record);

    int insertSelective(SysGroupStructureAcl record);

    SysGroupStructureAcl selectByPrimaryKey(Integer aclId);

    int updateByPrimaryKeySelective(SysGroupStructureAcl record);

    int updateByPrimaryKey(SysGroupStructureAcl record);
}