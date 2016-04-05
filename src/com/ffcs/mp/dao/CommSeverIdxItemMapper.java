package com.ffcs.mp.dao;

import com.ffcs.mp.entity.CommSeverIdxItem;

public interface CommSeverIdxItemMapper {
    int deleteByPrimaryKey(Integer idxItemId);

    int insert(CommSeverIdxItem record);

    int insertSelective(CommSeverIdxItem record);

    CommSeverIdxItem selectByPrimaryKey(Integer idxItemId);

    int updateByPrimaryKeySelective(CommSeverIdxItem record);

    int updateByPrimaryKey(CommSeverIdxItem record);
}