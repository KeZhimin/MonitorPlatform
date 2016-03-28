package com.ffcs.sys.service;

import java.util.Map;

import com.ffcs.sys.entity.SysGroupSeverAcl;
import com.github.pagehelper.PageInfo;

public interface SysGroupSeverAclService {
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysGroupSeverAcl entity);

    int insertSelective(SysGroupSeverAcl entity);
    PageInfo<SysGroupSeverAcl> selectList(PageInfo<SysGroupSeverAcl> pageInfo,Map<String,Object> params);
    SysGroupSeverAcl selectByPrimaryKey(Integer primaryKey);

    int updateByPrimaryKeySelective(SysGroupSeverAcl entity);

    int updateByPrimaryKey(SysGroupSeverAcl entity);
}
