package com.ffcs.mp.dao;

import com.ffcs.mp.entity.AppServerMonitorLog;

public interface AppServerMonitorLogMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(AppServerMonitorLog record);

    int insertSelective(AppServerMonitorLog record);

    AppServerMonitorLog selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(AppServerMonitorLog record);

    int updateByPrimaryKey(AppServerMonitorLog record);
}