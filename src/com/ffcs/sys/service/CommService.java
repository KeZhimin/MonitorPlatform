package com.ffcs.sys.service;

import java.util.List;


public interface CommService<T> {
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(T entity);

    int insertSelective(T entity);
    List<T> selectList();
    T selectByPrimaryKey(Integer primaryKey);

    int updateByPrimaryKeySelective(T entity);

    int updateByPrimaryKey(T entity);
}
