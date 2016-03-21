package com.ffcs.sys.service;

import java.util.List;
import java.util.Set;

import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;

public interface SysStructureInfoService extends CommService<SysStructureInfo>{
	List<SysStructureInfo> selectList(SysUser sysUser) ;
	
}
