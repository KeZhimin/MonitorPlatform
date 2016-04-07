package com.ffcs.mp.dao;

import com.ffcs.mp.entity.CommSeverOrgInfo;

public interface CommSeverOrgInfoMapper {
    int deleteByPrimaryKey(Integer orgId);

    int insert(CommSeverOrgInfo record);

    int insertSelective(CommSeverOrgInfo record);

    CommSeverOrgInfo selectByPrimaryKey(Integer orgId);

    int updateByPrimaryKeySelective(CommSeverOrgInfo record);

    int updateByPrimaryKey(CommSeverOrgInfo record);
}