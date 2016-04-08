package com.ffcs.mp.dao;

import com.ffcs.mp.entity.CommOrgInfo;

public interface CommOrgInfoMapper {
    int deleteByPrimaryKey(Integer orgId);

    int insert(CommOrgInfo record);

    int insertSelective(CommOrgInfo record);

    CommOrgInfo selectByPrimaryKey(Integer orgId);

    int updateByPrimaryKeySelective(CommOrgInfo record);

    int updateByPrimaryKey(CommOrgInfo record);
}