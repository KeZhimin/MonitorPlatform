package com.ffcs.sys.dao;

import com.ffcs.sys.entity.SysStructureInfo;

public interface SysStructureInfoMapper {
    int deleteByPrimaryKey(Integer structureId);

    int insert(SysStructureInfo record);

    int insertSelective(SysStructureInfo record);

    SysStructureInfo selectByPrimaryKey(Integer structureId);

    int updateByPrimaryKeySelective(SysStructureInfo record);

    int updateByPrimaryKey(SysStructureInfo record);
}