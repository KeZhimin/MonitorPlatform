package com.ffcs.mp.dao;

import com.ffcs.mp.entity.AppIfcMonitorLog;

public interface AppIfcMonitorLogMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(AppIfcMonitorLog record);

    int insertSelective(AppIfcMonitorLog record);

    AppIfcMonitorLog selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(AppIfcMonitorLog record);

    int updateByPrimaryKey(AppIfcMonitorLog record);
}