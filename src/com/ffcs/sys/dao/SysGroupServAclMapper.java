package com.ffcs.sys.dao;

import java.util.List;

import com.ffcs.sys.entity.SysGroupServAcl;

public interface SysGroupServAclMapper{
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysGroupServAcl entity);

    int insertSelective(SysGroupServAcl entity);

    SysGroupServAcl selectByPrimaryKey(Integer primaryKey);
    
    List<SysGroupServAcl> selectList();

    int updateByPrimaryKeySelective(SysGroupServAcl entity);

    int updateByPrimaryKey(SysGroupServAcl entity);
}