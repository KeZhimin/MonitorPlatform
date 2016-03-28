package com.ffcs.sys.service;

import java.util.Map;

import com.ffcs.sys.entity.SysGroupServAcl;
import com.github.pagehelper.PageInfo;

public interface SysGroupServAclService {
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysGroupServAcl entity);

    int insertSelective(SysGroupServAcl entity);
    PageInfo<SysGroupServAcl> selectList(PageInfo<SysGroupServAcl> pageInfo,Map<String,Object> params);
    SysGroupServAcl selectByPrimaryKey(Integer primaryKey);

    int updateByPrimaryKeySelective(SysGroupServAcl entity);

    int updateByPrimaryKey(SysGroupServAcl entity);
	     
}
