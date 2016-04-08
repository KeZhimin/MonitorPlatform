package com.ffcs.mp.dao;

import com.ffcs.mp.entity.StatIfcMonitorInfo;

public interface StatIfcMonitorInfoMapper {
    int insert(StatIfcMonitorInfo record);

    int insertSelective(StatIfcMonitorInfo record);
}