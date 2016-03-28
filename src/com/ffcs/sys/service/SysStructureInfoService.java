package com.ffcs.sys.service;

import java.util.List;
import java.util.Map;

import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;
import com.github.pagehelper.PageInfo;

public interface SysStructureInfoService {
	List<SysStructureInfo> selectList(SysUser sysUser) ;
	
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysStructureInfo entity);

    int insertSelective(SysStructureInfo entity);
    PageInfo<SysStructureInfo> selectList(PageInfo<SysStructureInfo> pageInfo,Map<String,Object> params);
    SysStructureInfo selectByPrimaryKey(Integer primaryKey);

    int updateByPrimaryKeySelective(SysStructureInfo entity);

    int updateByPrimaryKey(SysStructureInfo entity);
}
