package com.ffcs.sys.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;


public interface CommService<T> {
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(T entity);

    int insertSelective(T entity);
    PageInfo<T> selectList(PageInfo<T> pageInfo,Map<String,Object> params);
    T selectByPrimaryKey(Integer primaryKey);
    int updateByPrimaryKeySelective(T entity);
    int updateByPrimaryKey(T entity);
}
