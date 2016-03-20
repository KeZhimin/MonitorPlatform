package com.ffcs.sys.dao;

import java.util.List;

public interface CommMapper<T> {
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(T entity);

    int insertSelective(T entity);

    T selectByPrimaryKey(Integer primaryKey);
    
    List<T> selectList();

    int updateByPrimaryKeySelective(T entity);

    int updateByPrimaryKey(T entity);
}
