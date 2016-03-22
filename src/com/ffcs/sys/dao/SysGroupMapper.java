package com.ffcs.sys.dao;

import java.util.List;

import com.ffcs.sys.entity.SysGroup;

public interface SysGroupMapper extends CommMapper<SysGroup>{

	List<SysGroup> selectByUserId(Integer userId);
    
}