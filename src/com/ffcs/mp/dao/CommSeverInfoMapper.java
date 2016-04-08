package com.ffcs.mp.dao;

import com.ffcs.mp.entity.CommSeverInfo;

public interface CommSeverInfoMapper {
    int deleteByPrimaryKey(Long servId);

    int insert(CommSeverInfo record);

    int insertSelective(CommSeverInfo record);

    CommSeverInfo selectByPrimaryKey(Long servId);

    int updateByPrimaryKeySelective(CommSeverInfo record);

    int updateByPrimaryKey(CommSeverInfo record);
}