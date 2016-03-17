package com.ffcs.sys.service;

import com.ffcs.sys.entity.SysGroup;

public interface CommService<T> {
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(T entity);

    int insertSelective(T entity);

    SysGroup selectByPrimaryKey(Integer primaryKey);

    int updateByPrimaryKeySelective(T entity);

    int updateByPrimaryKey(T entity);
}
