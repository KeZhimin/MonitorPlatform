package com.ffcs.mp.dao;

import com.ffcs.mp.entity.CommSeverItemCfg;

public interface CommSeverItemCfgMapper {
    int deleteByPrimaryKey(Long idxItemCfgId);

    int insert(CommSeverItemCfg record);

    int insertSelective(CommSeverItemCfg record);

    CommSeverItemCfg selectByPrimaryKey(Long idxItemCfgId);

    int updateByPrimaryKeySelective(CommSeverItemCfg record);

    int updateByPrimaryKey(CommSeverItemCfg record);
}