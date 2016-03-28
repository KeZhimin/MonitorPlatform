package com.ffcs.sys.dao;

import java.util.List;

import com.ffcs.sys.entity.SysGroupSeverAcl;

public interface SysGroupSeverAclMapper {
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysGroupSeverAcl entity);

    int insertSelective(SysGroupSeverAcl entity);

    SysGroupSeverAcl selectByPrimaryKey(Integer primaryKey);
    
    List<SysGroupSeverAcl> selectList();

    int updateByPrimaryKeySelective(SysGroupSeverAcl entity);

    int updateByPrimaryKey(SysGroupSeverAcl entity);
}