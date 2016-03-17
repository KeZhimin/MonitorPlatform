package com.ffcs.mp.dao;

import com.ffcs.mp.entity.CommServerIdxTiem;

public interface CommServerIdxTiemMapper {
    int deleteByPrimaryKey(Integer idxItemId);

    int insert(CommServerIdxTiem record);

    int insertSelective(CommServerIdxTiem record);

    CommServerIdxTiem selectByPrimaryKey(Integer idxItemId);

    int updateByPrimaryKeySelective(CommServerIdxTiem record);

    int updateByPrimaryKey(CommServerIdxTiem record);
}