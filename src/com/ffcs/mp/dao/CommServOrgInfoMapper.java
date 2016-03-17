package com.ffcs.mp.dao;

import com.ffcs.mp.entity.CommServOrgInfo;

public interface CommServOrgInfoMapper {
    int deleteByPrimaryKey(Integer orgId);

    int insert(CommServOrgInfo record);

    int insertSelective(CommServOrgInfo record);

    CommServOrgInfo selectByPrimaryKey(Integer orgId);

    int updateByPrimaryKeySelective(CommServOrgInfo record);

    int updateByPrimaryKey(CommServOrgInfo record);
}