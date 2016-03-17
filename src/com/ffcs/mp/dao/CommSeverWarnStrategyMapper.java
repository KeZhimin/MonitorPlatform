package com.ffcs.mp.dao;

import com.ffcs.mp.entity.CommSeverWarnStrategy;

public interface CommSeverWarnStrategyMapper {
    int deleteByPrimaryKey(Long strategyId);

    int insert(CommSeverWarnStrategy record);

    int insertSelective(CommSeverWarnStrategy record);

    CommSeverWarnStrategy selectByPrimaryKey(Long strategyId);

    int updateByPrimaryKeySelective(CommSeverWarnStrategy record);

    int updateByPrimaryKey(CommSeverWarnStrategy record);
}