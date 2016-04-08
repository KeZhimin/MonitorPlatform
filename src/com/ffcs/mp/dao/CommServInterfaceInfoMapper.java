package com.ffcs.mp.dao;

import com.ffcs.mp.entity.CommServInterfaceInfo;

public interface CommServInterfaceInfoMapper {
    int deleteByPrimaryKey(Integer interfaceId);

    int insert(CommServInterfaceInfo record);

    int insertSelective(CommServInterfaceInfo record);

    CommServInterfaceInfo selectByPrimaryKey(Integer interfaceId);

    int updateByPrimaryKeySelective(CommServInterfaceInfo record);

    int updateByPrimaryKey(CommServInterfaceInfo record);
}