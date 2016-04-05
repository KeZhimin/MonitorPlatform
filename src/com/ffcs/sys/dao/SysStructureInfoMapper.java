package com.ffcs.sys.dao;

import java.util.List;
import java.util.Set;

import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;

public interface SysStructureInfoMapper {
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysStructureInfo entity);

    int insertSelective(SysStructureInfo entity);

    SysStructureInfo selectByPrimaryKey(Integer primaryKey);
    
    List<SysStructureInfo> selectList();

    int updateByPrimaryKeySelective(SysStructureInfo entity);

    int updateByPrimaryKey(SysStructureInfo entity);
	
	List<SysStructureInfo> selectList(SysUser sysUser);

	List<SysStructureInfo> select(SysStructureInfo sysStructureInfo);

	List<SysStructureInfo> selectByGroupId(Integer groupId);
	
	void deleteBatch(List<String> list);
}