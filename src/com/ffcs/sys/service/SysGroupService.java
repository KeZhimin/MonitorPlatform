package com.ffcs.sys.service;

import java.util.List;
import java.util.Map;

import com.ffcs.sys.entity.SysGroup;
import com.github.pagehelper.PageInfo;

public interface SysGroupService  {

	List<SysGroup> selectByUserId(Integer userId);
	
	int deleteByPrimaryKey(Integer primaryKey);

    int insert(SysGroup entity);

    int insertSelective(SysGroup group,Integer[] userId ,Integer serviceId,String strIds);
    
    PageInfo<SysGroup> selectList(PageInfo<SysGroup> pageInfo,SysGroup group);
    
    SysGroup selectByPrimaryKey(Integer primaryKey);

    int updateByPrimaryKeySelective(SysGroup entity);

    int updateByPrimaryKey(SysGroup entity);
    
    Map<String,Object> getGroup(Integer id);
    
    void updateGroup(SysGroup group,Integer[] userId ,Integer[] serviceId,String strIds);
    
    Integer enabledBatch(String ids);
    
    Integer deletedBatch(String ids);
	
}
