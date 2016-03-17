package com.ffcs.sys.service;

import com.ffcs.sys.entity.SysGroup;

public interface SysGroupService {
    int deleteByPrimaryKey(Integer groupId);

    int insert(SysGroup record);

    int insertSelective(SysGroup record);

    SysGroup selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(SysGroup record);

    int updateByPrimaryKey(SysGroup record);
}
