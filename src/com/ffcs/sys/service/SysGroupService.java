package com.ffcs.sys.service;

import java.util.List;

import com.ffcs.sys.entity.SysGroup;

public interface SysGroupService extends CommService<SysGroup> {

	List<SysGroup> selectByUserId(Integer userId);
	
}
