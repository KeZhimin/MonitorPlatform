package com.ffcs.sys.service;

import java.util.Map;

import com.ffcs.sys.entity.SysGroupStructureAcl;
import com.github.pagehelper.PageInfo;

public interface SysGroupStructureAclService  {
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysGroupStructureAcl entity);

    int insertSelective(SysGroupStructureAcl entity);
    PageInfo<SysGroupStructureAcl> selectList(PageInfo<SysGroupStructureAcl> pageInfo,Map<String,Object> params);
    SysGroupStructureAcl selectByPrimaryKey(Integer primaryKey);

    int updateByPrimaryKeySelective(SysGroupStructureAcl entity);

    int updateByPrimaryKey(SysGroupStructureAcl entity);
}
