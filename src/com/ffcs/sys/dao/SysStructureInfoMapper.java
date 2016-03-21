package com.ffcs.sys.dao;

import java.util.List;
import java.util.Set;

import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;

public interface SysStructureInfoMapper extends CommMapper<SysStructureInfo>{
	List<SysStructureInfo> selectList(SysUser sysUser);
}