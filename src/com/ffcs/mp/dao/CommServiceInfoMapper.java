package com.ffcs.mp.dao;

import com.ffcs.mp.entity.CommServiceInfo;

public interface CommServiceInfoMapper {
    int deleteByPrimaryKey(Integer servId);

    int insert(CommServiceInfo record);

    int insertSelective(CommServiceInfo record);

    CommServiceInfo selectByPrimaryKey(Integer servId);

    int updateByPrimaryKeySelective(CommServiceInfo record);

    int updateByPrimaryKey(CommServiceInfo record);
}